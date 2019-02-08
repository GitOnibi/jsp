package com.pr03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.pr03.Member_bean;

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
			System.out.println(e);
			return;
		}
	}
	
	public boolean getMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String sql = "SELECT * FROM member WHERE id='" + id + "'";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if( pw.equals(rs.getString("pw")) ) {
					return true;
				}
			}
			return false;
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public void setMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String sql = "INSERT INTO member(id, pw) VALUES('" + id + "', '" + pw + "')";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public String getId(HttpServletRequest request) {
		String id;
		id = request.getParameter("id");
		return id;
	}
}