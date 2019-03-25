package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Inven;

public class Inven_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Inven> getInvenList(String char_name) {
		System.out.println("- Character_DAO getInvenList");
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
						rs.getInt(		"item_opt1"	),
						rs.getInt(		"item_opt2"	),
						rs.getInt(		"item_opt3"	),
						rs.getInt(		"item_opt4"	),
						rs.getInt(		"item_opt5"	),
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
}
