package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Notice_content;

public class Notice_cont_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public  Notice_content insert(Notice_content data) throws SQLException {
		System.out.println("- Notice_cont_DAO insert");
		String	sql	= "INSERT INTO notice(num, cont) "
					+ "VALUES(?,?)";
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
}
