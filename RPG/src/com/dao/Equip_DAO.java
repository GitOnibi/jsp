package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Equip;
import com.bean.Inven;

public class Equip_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Equip> getEquipList(String char_name) {
		System.out.println("- Equip_DAO getEquipList");
		String sql	= "SELECT * FROM equip WHERE char_name = ?";
		List<Equip> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, char_name);
			rs		= pstmt.executeQuery();
			Equip data	= null;
			while(rs.next()) {
				data = new Equip(
						rs.getString(	"char_name"		),
						rs.getString(	"weapon_name"	),
						rs.getInt(		"weapon_code"	),
						rs.getString(	"amor_name"  	),
						rs.getInt(		"amor_code"  	),
						rs.getString(	"gloves_name"	),
						rs.getInt(		"gloves_code"	),
						rs.getString(	"boots_name" 	),
						rs.getInt(		"boots_code" 	),
						rs.getString(	"sub1_name"  	),
						rs.getInt(		"sub1_code"  	),
						rs.getString(	"sub2_name"  	),
						rs.getInt(		"sub2_code"  	),
						rs.getString(	"sub3_name"		),
						rs.getInt(		"sub3_code"		),
						rs.getString(	"sk1_name"   	),
						rs.getInt(		"sk1_code"   	),
						rs.getString(	"sk2_name"		),
						rs.getInt(		"sk2_code"		)
				);
				list.add(data);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Inven> getEquipableList(String char_name, int item_prop) {
		System.out.println("- Equip_DAO getEquipableList");
		String sql = "SELECT * FROM inventory, item WHERE inventory.item_code = item.item_code AND char_name = ? AND item_prop = ?";
		List<Inven> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, char_name);
			pstmt.setInt(	2, item_prop);
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
