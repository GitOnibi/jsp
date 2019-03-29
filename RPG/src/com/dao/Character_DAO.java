package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.bean.Character;

public class Character_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Character> getCharList(String user_id) {
		System.out.println("- Character_DAO getCharList");
		String sql = "SELECT * FROM character WHERE user_id = '" + user_id + "'";
		List<Character> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			Character data	= null;
			while(rs.next()) {
				data = new Character(
						rs.getString("user_id"),
						rs.getString("char_name"),
						rs.getInt("char_lv")
				);
				list.add(data);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Character> getChar(String user_id, String char_name) {
		System.out.println("- Character_DAO getChar");
		String sql = "SELECT * FROM character WHERE user_id = ? AND char_name = ?";
		List<Character> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, char_name);
			rs		= pstmt.executeQuery();
			Character data	= null;
			while(rs.next()) {
				data = new Character(
						rs.getString("user_id"),
						rs.getString("char_name"),
						rs.getInt("char_lv"),
						rs.getInt("char_str"),
						rs.getInt("char_dex"),
						rs.getInt("char_hp"),
						rs.getInt("char_atk"),
						rs.getInt("char_def"),
						rs.getInt("char_agi"),
						rs.getInt("char_crt"),
						rs.getInt("char_exp")
				);
				list.add(data);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setChar(Character ch) {
		System.out.println("- Character_DAO setChar");
		String sql = "INSERT INTO character(user_id, char_name, char_lv, char_str, char_dex, char_hp, char_atk, char_def, char_agi, char_crt, char_exp) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, 	ch.getUser_id()		);
			pstmt.setString(2, 	ch.getChar_name()	);
			pstmt.setInt(	3, 	ch.getChar_lv()		);
			pstmt.setInt(	4, 	ch.getChar_str()	);
			pstmt.setInt(	5, 	ch.getChar_dex()	);
			pstmt.setInt(	6, 	ch.getChar_hp()		);
			pstmt.setInt(	7, 	ch.getChar_atk()	);
			pstmt.setInt(	8, 	ch.getChar_def()	);
			pstmt.setInt(	9, 	ch.getChar_agi()	);
			pstmt.setInt(	10, ch.getChar_crt()	);
			pstmt.setInt(	11, ch.getChar_exp()	);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateChar(Character ch) {
		System.out.println("- Character_DAO updateChar");
		String sql = "UPDATE character SET char_lv = ?, char_str = ?, char_dex = ?, char_hp = ?, char_atk = ?, char_def = ?, char_agi = ?, char_crt = ?, char_exp = ? WHERE user_id = ? AND char_name = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(	1, 	ch.getChar_lv()		);
			pstmt.setInt(	2, 	ch.getChar_str()	);
			pstmt.setInt(	3, 	ch.getChar_dex()	);
			pstmt.setInt(	4, 	ch.getChar_hp()		);
			pstmt.setInt(	5, 	ch.getChar_atk()	);
			pstmt.setInt(	6, 	ch.getChar_def()	);
			pstmt.setInt(	7, 	ch.getChar_agi()	);
			pstmt.setInt(	8, 	ch.getChar_crt()	);
			pstmt.setInt(	9, 	ch.getChar_exp()	);
			pstmt.setString(10, ch.getUser_id()		);
			pstmt.setString(11, ch.getChar_name()	);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteChar(String user_id, String char_name) {
		System.out.println("- Character_DAO deleteChar");
		String sql = "DELETE FROM character WHERE user_id = ? AND char_name = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id	);
			pstmt.setString(2, char_name);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
