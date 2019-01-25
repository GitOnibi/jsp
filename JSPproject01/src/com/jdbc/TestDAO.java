package com.jdbc;

import java.util.*;

import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.jdbc.Member;

public class TestDAO {
	private Connection	conn;
	private Statement	stmt;
	private ResultSet	rs;
	private DataSource	ds;
	
	public TestDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch(Exception e) {
			System.out.println("driver 연결실패");
		}
	}
	
	public List<Member> getMember() {
		String sql = "SELECT * FROM member";
		List<Member> list = new ArrayList<Member>();
		try {
			conn	= ds.getConnection();
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			while(rs.next()) {
				Member temp = new Member();
				temp.setNum(rs.getInt("num"));
				temp.setName(rs.getString("name"));
				temp.setAge(rs.getInt("age"));
				temp.setAddr(rs.getString("addr"));
				temp.setGender(rs.getString("Gender"));
				list.add(temp);
			}
			conn.close();
			return list;
		} catch(Exception e) {
			return null;
		}
	}
	
	public String getName() {
		String sql = "SELECT * FROM SCHOOL_STUDENT";
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				//conn.close();
				return rs.getString("stu_name");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
