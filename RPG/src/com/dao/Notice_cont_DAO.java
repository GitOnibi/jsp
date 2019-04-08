package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Notice_content;

public class Notice_cont_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Notice_content insert(Notice_content data) throws SQLException {
		System.out.println("- Notice_cont_DAO insert");
		String	sql	= "INSERT INTO notice_content(num, cont) VALUES(?,?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, data.getNumber());
			pstmt.setString(2, data.getContent());
			int insert_cnt = pstmt.executeUpdate(); // 업데이트가 실행되면 0보다 큰 값을 반환 
			if(insert_cnt > 0) {
				return data;
			}
			return null;
		} finally {
			conn.close();
		}
	}
	
	public List<Notice_content> getCont(int no) throws SQLException {
		System.out.println("- Notice_cont_DAO getCont");
		String	sql	= "SELECT * FROM notice_content WHERE num = ?";
		List<Notice_content> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs		= pstmt.executeQuery();
			Notice_content temp = null;
			while(rs.next()) {
				temp = new Notice_content(
					rs.getInt("num"),
					rs.getString("cont")
				);
				list.add(temp);
			}
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conn.close();
		}
	}
	
	public void modifyCont(Notice_content data) throws SQLException {
		System.out.println("- Notice_cont_DAO modifyCont");
		String	sql	= "UPDATE notice_content SET cont = ? WHERE num = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, data.getContent());
			pstmt.setInt(2, data.getNumber());
			pstmt.executeUpdate();
		} finally {
			conn.close();
		}
	}
}
