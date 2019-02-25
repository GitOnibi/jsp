package com.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public class Member_DAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	public Member_DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean getMember(HttpServletRequest request) {
		String id	= request.getParameter("id");
		String pw	= request.getParameter("pw");
		String sql	= "SELECT * FROM user_table WHERE id = '" + id + "'";
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			
			while(rs.next()) {
				if( pw.equals(rs.getString("pw")) ) {
					return true;
				}
			}
			return false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkMember(String input) {
		String id = input;
		String sql	= "SELECT * FROM user_table WHERE id = '" + id + "'";
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			
			while(rs.next()) {
				if( id.equals(rs.getString("id")) ) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void setMember(HttpServletRequest request) {
		String id	= request.getParameter("id");
		String pw	= request.getParameter("pw");
		String sql	= "INSERT INTO user_table(id, pw) VALUES('" + id + "', '" + pw + "')";
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}