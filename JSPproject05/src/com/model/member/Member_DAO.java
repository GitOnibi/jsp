package com.model.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		String sql	= "SELECT * FROM member WHERE id = '" + id + "'";
		
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
		String sql	= "SELECT * FROM member WHERE id = '" + id + "'";
		
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
		String name	= request.getParameter("name");
		String sql	= "INSERT INTO member(id, pw, name) VALUES('" + id + "', '" + pw + "', '" + name + "')";
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member_bean> getInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sql = "SELECT * FROM member WHERE id = '" + id + "'";
		List<Member_bean> list = new ArrayList<Member_bean>();
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			while(rs.next()) {
				Member_bean temp = new Member_bean();
				temp.setId(		rs.getString("id")	);
				temp.setPw(		rs.getString("pw")	);
				temp.setName(	rs.getString("name"));
				temp.setNum(	rs.getInt("num")	);
				temp.setDept(	rs.getString("dept"));
				temp.setSub1(	rs.getString("sub1"));
				temp.setSub2(	rs.getString("sub2"));
				temp.setSub3(	rs.getString("sub3"));
				temp.setSub4(	rs.getString("sub4"));
				temp.setSub5(	rs.getString("sub5"));
				list.add(temp);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void inputMember(HttpServletRequest request) {
		String id	= (String) request.getAttribute("id");
		String dept	= request.getParameter("dept");
		String sub1	= request.getParameter("sub1");
		String sub2	= request.getParameter("sub2");
		String sub3	= request.getParameter("sub3");
		String sub4	= request.getParameter("sub4");
		String sub5	= request.getParameter("sub5");
		String sql	= "UPDATE member SET dept = '" + dept + "', sub1 = '" + sub1 + "', sub2 = '" + sub2 + "', sub3 = '" + sub3 + "', sub4 = '" + sub4 + "', sub5 = '" + sub5 + "' WHERE id = '" + id + "'";
		
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}