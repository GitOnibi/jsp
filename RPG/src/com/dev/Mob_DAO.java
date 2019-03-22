package com.dev;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mob_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Mob_bean> getMobList() {
		System.out.println("- Item_DAO getMobList");
		String sql = "SELECT * FROM mob";
		List<Mob_bean> list = new ArrayList<>();
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while(rs.next()) {
				Mob_bean temp = new Mob_bean(
						rs.getInt(		"mob_code"	),
						rs.getString(	"mob_name"	),
						rs.getInt(		"mob_lv"  	), 
						rs.getInt(		"mob_str" 	), 
						rs.getInt(		"mob_dex" 	),
						rs.getInt(		"mob_prop"	),
						rs.getInt(		"mob_opt1"	),
						rs.getInt(		"mob_opt2"	),
						rs.getInt(		"mob_opt3"	),
						rs.getInt(		"mob_opt4"	), 
						rs.getInt(		"mob_opt5"	),
						rs.getInt(		"mob_sk1"	),
						rs.getInt(		"mob_sk2"	), 
						rs.getInt(		"mob_sk3"	), 
						rs.getInt(		"mob_sk4"	), 
						rs.getInt(		"mob_sk5"	), 
						rs.getString(	"mob_sub"	), 
						rs.getInt(		"mob_atk"	), 
						rs.getInt(		"mob_def"	), 
						rs.getInt(		"mob_hp"	)
				);
				list.add(temp);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setMob(Mob_bean mb) {
		System.out.println("- Item_DAO setItem");
		String sql = "INSERT INTO mob(item_code, item_name, item_atk, item_def, item_opt1, item_opt2, item_opt3, item_opt4, item_opt5, item_sub, item_prop, item_price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(	1,	mb.getMob_code()	);
			pstmt.setString(2,	mb.getMob_name()	);
			pstmt.setInt(	3,	mb.getMob_lv() 		);
			pstmt.setInt(	4,	mb.getMob_str()		);
			pstmt.setInt(	5,	mb.getMob_dex()		);
			pstmt.setInt(	6,	mb.getMob_prop()	);
			pstmt.setInt(	7,	mb.getMob_opt1()	);
			pstmt.setInt(	8,	mb.getMob_opt2()	);
			pstmt.setInt(	9,	mb.getMob_opt3()	);
			pstmt.setInt(	10,	mb.getMob_opt4()	);
			pstmt.setInt(	11,	mb.getMob_opt5()	);
			pstmt.setInt(	12,	mb.getMob_sk1()		);
			pstmt.setInt(	13,	mb.getMob_sk2()		);
			pstmt.setInt(	14,	mb.getMob_sk3()		);
			pstmt.setInt(	15,	mb.getMob_sk4()		);
			pstmt.setInt(	16,	mb.getMob_sk5()		);
			pstmt.setString(17,	mb.getMob_sub()	);
			pstmt.setInt(	18,	mb.getMob_atk()		);
			pstmt.setInt(	19,	mb.getMob_def()		);
			pstmt.setInt(	20,	mb.getMob_hp()		);
			rs		= pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyItem(Item_bean ib) {
		System.out.println("- Item_DAO modifyItem");
		String sql = "UPDATE item SET item_name = ?, item_atk = ?, item_def = ?, item_opt1 = ?, item_opt2 = ?, item_opt3 = ?, item_opt4 = ?, item_opt5 = ?, item_sub = ?, item_prop = ?, item_price = ? WHERE item_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1,	ib.getItem_name()	);
			pstmt.setInt(	2,	ib.getItem_atk()	);
			pstmt.setInt(	3,	ib.getItem_def()	);
			pstmt.setInt(	4,	ib.getItem_opt1()	);
			pstmt.setInt(	5,	ib.getItem_opt2()	);
			pstmt.setInt(	6,	ib.getItem_opt3()	);
			pstmt.setInt(	7,	ib.getItem_opt4()	);
			pstmt.setInt(	8,	ib.getItem_opt5()	);
			pstmt.setString(9,	ib.getItem_sub()	);
			pstmt.setInt(	10,	ib.getItem_prop()	);
			pstmt.setInt(	11,	ib.getItem_price()	);
			pstmt.setInt(	12,	ib.getItem_code()	);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(String item_code) {
		System.out.println("- Item_DAO deleteItem");
		String sql = "DELETE FROM item WHERE item_code = '" + item_code + "'";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
