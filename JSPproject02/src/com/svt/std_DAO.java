package com.svt;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.svt.std_bean;

public class std_DAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	// idx number(4, 0)
	// num number(4, 0) primary key
	// name varchar2(100)
	// class_ number(4, 0)
	// tall number(3, 0)
	// teacher varchar2(100)
	
	public std_DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception e) {
			System.out.println(e);
			return;
		}
	}
	
	public List<std_bean> getStd() {
		String sql = "SELECT * FROM info";
		List<std_bean> list = new ArrayList<std_bean>();
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				std_bean temp = new std_bean();
				temp.setNum(	rs.getInt("num")		);
				temp.setName(	rs.getString("name")	);
				temp.setClass_(	rs.getInt("class_")		);
				temp.setTall(	rs.getInt("tall")		);
				temp.setTeacher(rs.getString("teacher")	);
				list.add(temp);
			}
			return list;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void setStd(HttpServletRequest request) {
		String num		= request.getParameter("num");
		String name		= request.getParameter("name");
		String class_	= request.getParameter("class_");
		String tall		= request.getParameter("tall");
		String teacher	= request.getParameter("teacher");
		
		String sql = "INSERT INTO info(num, name, class_, tall, teacher) ";
		sql += "VALUES(" + num + ", '" + name + "', " + class_ + ", " + tall + ", '" + teacher + "')";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
}
