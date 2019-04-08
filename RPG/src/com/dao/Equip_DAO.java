package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Equip;
import com.dev.Item_bean;

public class Equip_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Item_bean> getEquipList(String user_id, String char_name) {
		System.out.println("- Equip_DAO getEquipList");
		List<Item_bean> list = new ArrayList<>();
		
		String sql	= "SELECT * FROM equip, item WHERE equip.item_code = item.item_code "
					+ "AND user_id = ? AND char_name = ? ORDER BY equip.idx ASC";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id	);
			pstmt.setString(2, char_name);
			rs		= pstmt.executeQuery();
			Item_bean temp = null;
			while(rs.next()) {
				temp = new Item_bean(
					rs.getInt("item_code"),
					rs.getString("item_name"),
					rs.getInt("item_atk"),
					rs.getInt("item_def"),
					rs.getString("item_sub"),
					rs.getInt("item_prop"),
					rs.getInt("item_price")
				);
				list.add(temp);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void initEquip(int idx, String user_id, String char_name) {
		System.out.println("- Equip_DAO initEquip");
		String sql	= "INSERT INTO equip(idx, item_code, char_name, user_id) "
					+ "VALUES(?, 0, ?, ?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, char_name);
			pstmt.setString(3, user_id	);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Item_bean> getEquipableList(String user_id, String char_name, int item_prop) {
		System.out.println("- Equip_DAO getEquipableList");
		String sql	= "SELECT * FROM inventory, item "
					+ "WHERE inventory.item_code = item.item_code "
					+ "AND inventory.user_id = ? "
					+ "AND inventory.char_name = ? "
					+ "AND item.item_prop = ?";
		List<Item_bean> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, char_name);
			pstmt.setInt(	3, item_prop);
			rs		= pstmt.executeQuery();
			Item_bean data	= null;
			while(rs.next()) {
				data = new Item_bean(
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateEquipList(Equip equip) {
		System.out.println("- Equip_DAO updateEquipList");
		String sql	= "UPDATE equip SET item_code = ? WHERE idx = ? AND user_id = ? AND char_name = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(		1,	equip.getItem_code());
			pstmt.setInt(		2,	equip.getIdx()		);
			pstmt.setString(	3,	equip.getUser_id()	);
			pstmt.setString(	4,	equip.getChar_name());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
