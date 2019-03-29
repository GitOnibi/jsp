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
	
	public void initEquip(String char_name) {
		System.out.println("- Equip_DAO initEquip");
		String sql	= "INSERT INTO equip(char_name, weapon_name, weapon_code, amor_name, amor_code, " 
					+ "gloves_name, gloves_code, boots_name, boots_code, sub1_name, sub1_code, "
					+ "sub2_name, sub2_code, sub3_name, sub3_code, sk1_name, sk1_code, sk2_name, sk2_code) "
					+ "VALUES(?, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1,	char_name);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
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
	
	public void updateEquipList(Equip equip) {
		System.out.println("- Equip_DAO updateEquipList");
		String sql	= "UPDATE equip SET "
					+ "weapon_name = ?, weapon_code = ?, amor_name = ?, amor_code = ?, gloves_name = ?, gloves_code = ?, boots_name = ?, boots_code = ? ,"
					+ "sub1_name = ?, sub1_code = ?, sub2_name = ?, sub2_code = ?, sub3_name = ?, sub3_code = ?, sk1_name = ?, sk1_code = ?, sk2_name = ?, sk2_code = ? "
					+ "WHERE char_name = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1,	equip.getWeapon_name()	);
			pstmt.setInt(	2,	equip.getWeapon_code()	);
			pstmt.setString(3,	equip.getAmor_name()  	);
			pstmt.setInt(	4,	equip.getAmor_code()  	);
			pstmt.setString(5,	equip.getGloves_name()	);
			pstmt.setInt(	6,	equip.getGloves_code()	);
			pstmt.setString(7,	equip.getBoots_name() 	);
			pstmt.setInt(	8,	equip.getBoots_code() 	);
			pstmt.setString(9,	equip.getSub1_name()  	);
			pstmt.setInt(	10,	equip.getSub1_code()  	);
			pstmt.setString(11,	equip.getSub2_name()  	);
			pstmt.setInt(	12,	equip.getSub2_code()  	);
			pstmt.setString(13,	equip.getSub3_name()	);
			pstmt.setInt(	14,	equip.getSub3_code()	);
			pstmt.setString(15,	equip.getSk1_name()   	);
			pstmt.setInt(	16,	equip.getSk1_code()   	);
			pstmt.setString(17,	equip.getSk2_name()		);
			pstmt.setInt(	18,	equip.getSk2_code()		);
			pstmt.setString(19,	equip.getChar_name()	);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
