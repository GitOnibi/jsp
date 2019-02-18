package com.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.command.Handler;

public class SigninHandler implements Handler{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {	
		setMember(request);
		
		return "index.jsp";
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
}
