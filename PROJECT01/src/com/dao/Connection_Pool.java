package com.dao;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Connection_Pool extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		jdbcDriver();
		ConnectionPool();
		System.out.println("connection pool inited");
	}
	
	private void jdbcDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e ) {
			throw new RuntimeException("driver 로드실패", e); 
		}
	}
	
	private void ConnectionPool() {
		try {
			String url		= "jdbc:oracle:thin:@localhost:1521:orcl";
			String user		= "onigawara";
			String password	= "dbwls12";
			ConnectionFactory conn = new DriverManagerConnectionFactory(url,user,password);			
			PoolableConnectionFactory pool = new PoolableConnectionFactory(conn,null);	
			GenericObjectPoolConfig<PoolableConnection> poolconf = new GenericObjectPoolConfig<PoolableConnection>();
			poolconf.setTimeBetweenEvictionRunsMillis(60000L*5L);
			poolconf.setMinIdle(5);
			poolconf.setMaxTotal(100);
			poolconf.setTestWhileIdle(true);
			GenericObjectPool<PoolableConnection> connpool = new GenericObjectPool<>(pool,poolconf);
			pool.setPool(connpool);
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("pr01", connpool);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}