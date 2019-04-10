package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.Notice;

public class Notice_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	
	public int getNum() throws SQLException, IOException {
		int num = 1;
		String sql = "SELECT MAX(num) AS mnum FROM notice";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("mnum") + 1;
				return num;
			}
		} finally {
			conn.close();
		}
		return num;
	}
	
	public Notice insert(Notice data) throws SQLException, IOException {
		System.out.println("- Notice_DAO insert");
		String	sql	= "INSERT INTO notice(num, user_id, title, regdate, moddate, read_cnt) "
					+ "VALUES(?,?,?,?,?,0)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, data.getNumber());
			pstmt.setString(2, data.getUser_id());
			pstmt.setString(3, data.getTitle());
			pstmt.setTimestamp(4, toTimestamp(data.getRegdate()));
			pstmt.setTimestamp(5, toTimestamp(data.getModdate()));
			int insert_cnt = pstmt.executeUpdate(); // 업데이트가 실행되면 0보다 큰 값을 반환 
			if(insert_cnt > 0) {
				Statement stmt = conn.createStatement();
				String sql2 = "SELECT * FROM notice ORDER BY num DESC";
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					int number = rs.getInt("num");
					return new Notice(
						number,
						rs.getString("user_id"),
						rs.getString("title"),
						rs.getDate("regdate"),
						rs.getDate("moddate"),
						0
					);
				}
				return null;
			}
		} finally {
			conn.close();
		}
		return null;
	}
	
	public List<Notice> select_notice(int start, int size) throws SQLException, IOException {
		System.out.println("- Notice_DAO select_notice");
		String	sql	= "SELECT * FROM (SELECT ROWNUM AS rn, a.* FROM (SELECT * FROM notice ORDER BY num DESC) a) "
					+ "WHERE rn BETWEEN ? AND ?";
		List<Notice> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, size + start);
			rs		= pstmt.executeQuery();
			Notice temp = null;
			while(rs.next()) {
				temp = new Notice(
					rs.getInt("num"),
					rs.getString("user_id"),
					rs.getString("title"),
					rs.getDate("regdate"),
					rs.getDate("moddate"),
					rs.getInt("read_cnt")
				);
				list.add(temp);
			}
			return list;
		} finally {
			conn.close();
		}
	}
	
	public int select_cnt() throws SQLException, IOException {
		Statement stmt = null;
		String sql = "SELECT COUNT(*) AS cnt FROM notice";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			stmt	= conn.createStatement();
			rs		= stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			return 0;
		} finally {
			conn.close();
		}
	}
	
	public Notice getNotice(int num) throws SQLException, IOException {
		System.out.println("- Notice_DAO getNotice");
		String	sql	= "SELECT * FROM notice WHERE num = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs		= pstmt.executeQuery();
			Notice temp = null;
			while(rs.next()) {
				temp = new Notice(
					rs.getInt("num"),
					rs.getString("user_id"),
					rs.getString("title"),
					rs.getDate("regdate"),
					rs.getDate("moddate"),
					rs.getInt("read_cnt")
				);
			}
			return temp;
		} finally {
			conn.close();
		}
	}
}
