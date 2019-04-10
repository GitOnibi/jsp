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
	
	public List<Mob_bean> getMobList() throws SQLException, IOException {
		System.out.println("- Mob_DAO getMobList");
		String sql = "SELECT * FROM mob ORDER BY mob_code ASC";
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
						rs.getString(	"mob_sub"	), 
						rs.getInt(		"mob_atk"	), 
						rs.getInt(		"mob_def"	), 
						rs.getInt(		"mob_hp"	),
						rs.getInt(		"mob_exp"	)
				);
				list.add(temp);
			}
			return list;
		} finally {
			conn.close();
		}
	}
	
	public void setMob(Mob_bean mb) throws SQLException, IOException {
		System.out.println("- Mob_DAO setMob");
		String sql = "INSERT INTO mob(mob_code, mob_name, mob_lv, mob_str, mob_dex, mob_prop, mob_sk1, mob_sk2, mob_sk3, mob_sub, mob_atk, mob_def, mob_hp, mob_exp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pstmt.setString(10,	mb.getMob_sub()		);
			pstmt.setInt(	11,	mb.getMob_atk()		);
			pstmt.setInt(	12,	mb.getMob_def()		);
			pstmt.setInt(	13,	mb.getMob_hp()		);
			pstmt.setInt(	14,	mb.getMob_exp()		);
			rs		= pstmt.executeQuery();
		} finally {
			conn.close();
		}
	}
	
	public void modifyMob(Mob_bean mb) throws SQLException, IOException {
		System.out.println("- Mob_DAO modifyMob");
		String sql = "UPDATE mob SET mob_name = ?, mob_lv = ?, mob_str = ?, mob_dex = ?, mob_prop = ?, mob_sk1 = ?, mob_sk2 = ?, mob_sk3 = ?, mob_sub = ?, mob_atk = ?, mob_def = ?, mob_hp = ?, mob_exp = ? WHERE mob_code = ?";
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
			pstmt.setString(9,	mb.getMob_sub()		);
			pstmt.setInt(	10,	mb.getMob_atk()		);
			pstmt.setInt(	11,	mb.getMob_def()		);
			pstmt.setInt(	12,	mb.getMob_hp()		);
			pstmt.setInt(	13,	mb.getMob_exp()		);
			pstmt.setInt(	14,	mb.getMob_code()	);
			rs		= pstmt.executeQuery();
		} finally {
			conn.close();
		}
	}
	
	public void deleteMob(int mob_code) throws SQLException, IOException {
		System.out.println("- Mob_DAO deleteItem");
		String sql = "DELETE FROM mob WHERE mob_code = ?";
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, mob_code);
			pstmt.executeQuery();
		} finally {
			conn.close();
		}
	}
	
	public Mob_bean getMob(int mob_code) throws SQLException, IOException {
		System.out.println("- Mob_DAO getMob");
		String sql = "SELECT * FROM mob WHERE mob_code = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, mob_code);
			rs = pstmt.executeQuery();
			Mob_bean mb = null;
			while(rs.next()) {
				mb = new Mob_bean(
						rs.getInt("mob_code"),
						rs.getString("mob_name"),
						rs.getInt("mob_lv"),
						rs.getInt("mob_str"),
						rs.getInt("mob_dex"),
						rs.getInt("mob_prop"),
						rs.getInt("mob_sk1"),
						rs.getInt("mob_sk2"),
						rs.getInt("mob_sk3"),
						rs.getString("mob_sub"),
						rs.getInt("mob_atk"),
						rs.getInt("mob_def"),
						rs.getInt("mob_hp"),
						rs.getInt("mob_exp")
				);
			}
			return mb;
		} finally {
			conn.close();
		}
	}
	
	public List<Integer> dropItem(int mob_code) throws SQLException, IOException {
		System.out.println("- Mob_DAO dropItem");
		String sql = "SELECT * FROM mob_item WHERE mob_code = ?";
		
		try {
			conn	= DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt	= conn.prepareStatement(sql);
			pstmt.setInt(1, mob_code);
			rs = pstmt.executeQuery();
			List<Integer> list = new ArrayList<>();
			while(rs.next()) {
				list.add(rs.getInt("item_code"));
			}
			return list;
		} finally {
			conn.close();
		}
	}
}
