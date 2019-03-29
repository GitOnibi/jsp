package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Item_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Item_bean> getItemList() {
		System.out.println("- Item_DAO getItemList");
		String sql = "SELECT * FROM item ORDER BY item_code";
		List<Item_bean> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs.next()) {
				Item_bean temp = new Item_bean(
						rs.getInt(		"item_code"	),
						rs.getString(	"item_name"	),
						rs.getInt(		"item_atk"	), 
						rs.getInt(		"item_def"	), 
						rs.getString(	"item_sub"	), 
						rs.getInt(		"item_prop"	),
						rs.getInt(		"item_price")
				);
				list.add(temp);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setItem(Item_bean ib) {
		System.out.println("- Item_DAO setItem");
		String sql = "INSERT INTO item(item_code, item_name, item_atk, item_def, item_sub, item_prop, item_price) VALUES(?,?,?,?,?,?,?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(	1, ib.getItem_code()	);
			pstmt.setString(2, ib.getItem_name()	);
			pstmt.setInt(	3, ib.getItem_atk()		);
			pstmt.setInt(	4, ib.getItem_def()		);
			pstmt.setString(5, ib.getItem_sub()		);
			pstmt.setInt(	6, ib.getItem_prop()	);
			pstmt.setInt(	7, ib.getItem_price()	);
			rs		= pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyItem(Item_bean ib) {
		System.out.println("- Item_DAO modifyItem");
		String sql = "UPDATE item SET item_name = ?, item_atk = ?, item_def = ?, item_sub = ?, item_prop = ?, item_price = ? WHERE item_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1,	ib.getItem_name()	);
			pstmt.setInt(	2,	ib.getItem_atk()	);
			pstmt.setInt(	3,	ib.getItem_def()	);
			pstmt.setString(4,	ib.getItem_sub()	);
			pstmt.setInt(	5,	ib.getItem_prop()	);
			pstmt.setInt(	6,	ib.getItem_price()	);
			pstmt.setInt(	7,	ib.getItem_code()	);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(int item_code) {
		System.out.println("- Item_DAO deleteItem");
		String sql = "DELETE FROM item WHERE item_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1,	item_code);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getItemName(int item_code) {
		System.out.println("- Item_DAO getItemName");
		String sql = "SELECT item_name FROM item WHERE item_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1,	item_code);
			rs = pstmt.executeQuery();
			String item_name = null;
			while(rs.next()) {
				item_name = rs.getString("item_name");
			}
			return item_name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Item_bean getItemStatus(int item_code) {
		System.out.println("- Item_DAO getItemStatus");
		String sql = "SELECT * FROM item WHERE item_code = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1,	item_code);
			rs = pstmt.executeQuery();
			Item_bean temp = null;
			while(rs.next()) {
				temp = new Item_bean(
					rs.getInt(		"item_code"	),
					rs.getString(	"item_name"	),
					rs.getInt(		"item_atk"	),
					rs.getInt(		"item_def"	),
					rs.getString(	"item_sub"	),
					rs.getInt(		"item_prop"	),
					rs.getInt(		"item_price")
				);
			}
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
