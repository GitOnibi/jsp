package com.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.command.Handler;

public class LoginHandler implements Handler {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if(getMember(request)) {
			session.setAttribute("id", request.getParameter("id"));
		} else {
			session.invalidate();
			String msg = "id 또는 pw 가 잘못입력되었습니다.";
			request.setAttribute("msg", msg);
		}
		
		return "index.jsp";
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
}
