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
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Mob_bean> getMobList() {
		System.out.println("- Mob_DAO getMobList");
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
		System.out.println("- Mob_DAO setMob");
		String sql = "INSERT INTO mob(mob_code, mob_name, mob_lv, mob_str, mob_dex, mob_prop, mob_sk1, mob_sk2, mob_sk3, mob_sk4, mob_sk5, mob_sub, mob_atk, mob_def, mob_hp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(	1,	mb.getMob_code()	);
			pstmt.setString(2,	mb.getMob_name()	);
			pstmt.setInt(	3,	mb.getMob_lv() 		);
			pstmt.setInt(	4,	mb.getMob_str()		);
			pstmt.setInt(	5,	mb.getMob_dex()		);
			pstmt.setInt(	6,	mb.getMob_prop()	);
			pstmt.setInt(	7,	mb.getMob_sk1()		);
			pstmt.setInt(	8,	mb.getMob_sk2()		);
			pstmt.setInt(	9,	mb.getMob_sk3()		);
			pstmt.setInt(	10,	mb.getMob_sk4()		);
			pstmt.setInt(	11,	mb.getMob_sk5()		);
			pstmt.setString(12,	mb.getMob_sub()		);
			pstmt.setInt(	13,	mb.getMob_atk()		);
			pstmt.setInt(	14,	mb.getMob_def()		);
			pstmt.setInt(	15,	mb.getMob_hp()		);
			rs		= pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyMob(Mob_bean mb) {
		System.out.println("- Mob_DAO modifyMob");
		String sql = "UPDATE mob SET mob_name = ?, mob_lv = ?, mob_str = ?, mob_dex = ?, mob_prop = ?, mob_sk1 = ?, mob_sk2 = ?, mob_sk3 = ?, mob_sk4 = ?, mob_sk5 = ?, mob_sub = ?, mob_atk = ?, mob_def = ?, mob_hp = ? WHERE mob_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setString(1,	mb.getMob_name()	);
			pstmt.setInt(	2,	mb.getMob_lv() 		);
			pstmt.setInt(	3,	mb.getMob_str()		);
			pstmt.setInt(	4,	mb.getMob_dex()		);
			pstmt.setInt(	5,	mb.getMob_prop()	);
			pstmt.setInt(	6,	mb.getMob_sk1()		);
			pstmt.setInt(	7,	mb.getMob_sk2()		);
			pstmt.setInt(	8,	mb.getMob_sk3()		);
			pstmt.setInt(	9,	mb.getMob_sk4()		);
			pstmt.setInt(	10,	mb.getMob_sk5()		);
			pstmt.setString(11,	mb.getMob_sub()		);
			pstmt.setInt(	12,	mb.getMob_atk()		);
			pstmt.setInt(	13,	mb.getMob_def()		);
			pstmt.setInt(	14,	mb.getMob_hp()		);
			pstmt.setInt(	15,	mb.getMob_code()	);
			rs		= pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMob(String mob_code) {
		System.out.println("- Mob_DAO deleteItem");
		String sql = "DELETE FROM mob WHERE mob_code = '" + mob_code + "'";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
