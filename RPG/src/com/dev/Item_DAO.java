package com.dev;

import java.io.IOException;
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
		String sql = "SELECT * FROM item";
		List<Item_bean> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs.next()) {
				Item_bean temp = new Item_bean(
						rs.getInt("item_code"),
						rs.getString("item_name"),
						rs.getInt("item_atk"), 
						rs.getInt("item_def"), 
						rs.getInt("item_opt1"),
						rs.getInt("item_opt2"),
						rs.getInt("item_opt3"),
						rs.getInt("item_opt4"),
						rs.getInt("item_opt5"),
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
	
	public void setItem() {
		
	}
	
	public void updateItem() {
		
	}
}
