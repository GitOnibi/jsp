package com.svt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PoolDAO {
	private Connection	conn;
	private Statement	stmt;
	private ResultSet	rs;
	private String		driver;
	
	public PoolDAO() {
		driver = "jdbc:apache:commons:dbcp:jsptest";
	}
	
	public List<std_bean> getStd() {
		String sql = "SELECT * FROM info";
		List<std_bean> list = new ArrayList<std_bean>();
		
		try {
			conn = DriverManager.getConnection(driver);
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
		} catch(SQLException e) {
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
			conn = DriverManager.getConnection(driver);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
}