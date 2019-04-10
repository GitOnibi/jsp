package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Inven;

public class Inven_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Inven> getInvenList(String char_name) throws SQLException, IOException {
		System.out.println("- Inven_DAO getInvenList");
		String sql = "SELECT * FROM inventory, item WHERE inventory.item_code = item.item_code AND char_name = ?";
		List<Inven> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, char_name);
			rs		= pstmt.executeQuery();
			Inven data	= null;
			while(rs.next()) {
				data = new Inven(
						rs.getString(	"char_name"),
						rs.getInt(		"item_code"	),
						rs.getString(	"item_name"	),
						rs.getInt(		"item_atk"	), 
						rs.getInt(		"item_def"	),
						rs.getString(	"item_sub"	), 
						rs.getInt(		"item_prop"	),
						rs.getInt(		"item_price")
				);
				list.add(data);
			}
			return list;
		} finally {
			conn.close();
		}
	}
	
	public void sellItem(String user_id, String char_name, int item_code) throws SQLException, IOException {
		System.out.println("- Inven_DAO sellItem");
		String sql = "DELETE inventory WHERE item_code = ? AND user_id = ? AND char_name = ? AND rownum = 1";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, item_code);
			pstmt.setString(2, user_id);
			pstmt.setString(3, char_name);
			pstmt.executeUpdate();
		} finally {
			conn.close();
		}
	}
	
	public void insertInven(String user_id, String char_name, int item_code) throws SQLException, IOException {
		System.out.println("- Inven_DAO insertInven");
		String sql = "INSERT INTO inventory(user_id, char_name, item_code) VALUES(?,?,?)";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, char_name);
			pstmt.setInt(3, item_code);
			pstmt.executeUpdate();
		} finally {
			conn.close();
		}
	}
}