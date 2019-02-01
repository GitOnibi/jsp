package com.svt;

import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPoolConfig;



public class CPinit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		jdbcDriver();
		ConnectionPool();
	}
	
	private void jdbcDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e ) {
			throw new RuntimeException("driver 로드 실패", e); 
		}
	}
	

	
	private void ConnectionPool() {
		try {
			String url		= "jdbc:oracle:thin:@localhost:1521:orcl";
			String user		= "onigawara";
			String password	= "dbwls12";
			ConnectionFactory conn = new DriverManagerConnectionFactory(url, user, password);
			PoolableConnectionFactory pool = new PoolableConnectionFactory(conn, null);
			GenericObjectPoolConfig<PoolableConnection> poolconf = new GenericObjectPoolConfig<>();
			poolconf.setTimeBetweenEvictionRunsMillis(60000L*5L); // 검사주기
			poolconf.setMinIdle(5); // 
			poolconf.setMaxTotal(100); // 동시 사용 최대수
			poolconf.setTestWhileIdle(true); // 유효성검사여부
			GenericObjectPool<PoolableConnection> connpool = new GenericObjectPool<>(pool);
			pool.setPool(connpool);
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("jsptest", connpool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
