package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bean.Equip;
import com.bean.Inven;
import com.dev.Item_DAO;
import com.dev.Item_bean;

public class Equip_DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Equip> getEquipList(String user_id, String char_name) {
		System.out.println("- Equip_DAO getEquipList");
		String sql	= "SELECT * FROM equip WHERE user_id = ? AND char_name = ?";
		List<Equip> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1, user_id	);
			pstmt.setString(2, char_name);
			rs		= pstmt.executeQuery();
			Equip data	= null;
			while(rs.next()) {
				data = new Equip(
						rs.getString(	"user_id"		),
						rs.getString(	"char_name"		),
						rs.getInt(		"weapon_code"	),
						rs.getInt(		"amor_code"  	),
						rs.getInt(		"gloves_code"	),
						rs.getInt(		"boots_code" 	),
						rs.getInt(		"sub1_code"  	),
						rs.getInt(		"sub2_code"  	),
						rs.getInt(		"sub3_code"		),
						rs.getInt(		"sk1_code"   	),
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
	
	public void initEquip(String user_id, String char_name) {
		System.out.println("- Equip_DAO initEquip");
		String sql	= "INSERT INTO equip(user_id, char_name, weapon_code, amor_code, gloves_code, boots_code, sub1_code, sub2_code, sub3_code, sk1_code, sk2_code) "
					+ "VALUES(?, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0, '0', 0)";
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
					+ "weapon_code = ?, amor_code = ?, gloves_code = ?, boots_code = ? , sub1_code = ?, sub2_code = ?, sub3_code = ?, sk1_code = ?, sk2_code = ? "
					+ "WHERE user_id = ? AND char_name = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(	1,	equip.getWeapon_code()	);
			pstmt.setInt(	2,	equip.getAmor_code()  	);
			pstmt.setInt(	3,	equip.getGloves_code()	);
			pstmt.setInt(	4,	equip.getBoots_code() 	);
			pstmt.setInt(	5,	equip.getSub1_code()  	);
			pstmt.setInt(	6,	equip.getSub2_code()  	);
			pstmt.setInt(	7,	equip.getSub3_code()	);
			pstmt.setInt(	8,	equip.getSk1_code()   	);
			pstmt.setInt(	9,	equip.getSk2_code()		);
			pstmt.setString(10,	equip.getUser_id()		);
			pstmt.setString(11,	equip.getChar_name()	);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Integer> getEquipStatus(Equip equip) {
		List<Integer> list = new ArrayList<>();
		list.add(equip.getWeapon_code()	);
		list.add(equip.getAmor_code()  	);
		list.add(equip.getGloves_code()	);
		list.add(equip.getBoots_code() 	);
		list.add(equip.getSub1_code()  	);
		list.add(equip.getSub2_code()  	);
		list.add(equip.getSub3_code()	);
		list.add(equip.getSk1_code()   	);
		list.add(equip.getSk2_code()	);
		
		Map<String, Integer> map = new HashMap<>();
		Item_DAO idao = new Item_DAO();
		Item_bean ib = null;
		int	sum_atk = 0,
			sum_def = 0;
		for(int i = 0; i < 9; i ++) {
			ib = idao.getItemInfo(list.get(i));
			sum_atk += ib.getItem_atk();
			sum_def += ib.getItem_def();
		}
		map.put("sum_atk", sum_atk);
		map.put("sum_def", sum_def);
		return map;
	}
}
