package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Skill;

public class Skill_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Skill> getSkList() throws SQLException, IOException {
		System.out.println("- Skill_DAO getSkillList");
		String sql = "SELECT * FROM skill";
		List<Skill> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			Skill data	= null;
			if(rs.next()) {
				data = new Skill(
						rs.getInt("sk_code"),
						rs.getString("sk_name"),
						rs.getInt("sk_atk"),
						rs.getInt("sk_def"),
						rs.getString("sk_sub")
				);
				list.add(data);
			}
			return list;
		} finally {
			conn.close();
		}
	}
	
	public List<Skill> getHaveSkList(String char_name) throws SQLException, IOException {
		System.out.println("- Skill_DAO getHaveSkList");
		String sql = "SELECT * FROM skill WHERE char_name = ?";
		List<Skill> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, char_name);
			rs		= pstmt.executeQuery();
			Skill data	= null;
			if(rs.next()) {
				data = new Skill(
						rs.getInt("sk_code"),
						rs.getString("sk_name"),
						rs.getInt("sk_atk"),
						rs.getInt("sk_def"),
						rs.getString("sk_sub")
				);
				list.add(data);
			}
			return list;
		} finally {
			conn.close();
		}
	}
}
