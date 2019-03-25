package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Member;

public class Member_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Member getMemberId(String id) throws SQLException, IOException {
		System.out.println("- Member_DAO getMemberId");
		String sql = "SELECT * FROM member WHERE user_id = '" + id + "'";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			Member data	= null;
			if(rs.next()) {
				data = new Member(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						toDate(rs.getTimestamp("ndate")),
						rs.getString("user_email")
				);
			}
			return data;
		} finally {}
	}
	
	public Date toDate(Timestamp date) { return date == null? null:new Date(date.getTime()); }
	
	public void insert(Member data) throws SQLException, IOException {
		System.out.println("- Member_DAO insert");
		String sql	= "INSERT INTO member(user_id, user_pw, ndate, user_email) VALUES(?, ?, ?, ?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(	1, data.getUser_id());
			pstmt.setString(	2, data.getUser_pw());
			pstmt.setTimestamp(	3, new Timestamp(data.getNdate().getTime()));
			pstmt.setString(	4, data.getUser_email());
			pstmt.executeQuery();
		} finally {}
	}
	
	public List<Member> getMemberList() {
		System.out.println("- Member_DAO getMemberId");
		String sql = "SELECT * FROM member";
		List<Member> list = new ArrayList<>();
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			Member data	= null;
			while(rs.next()) {
				data = new Member(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						toDate(rs.getTimestamp("ndate")),
						rs.getString("user_email")
				);
				list.add(data);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}