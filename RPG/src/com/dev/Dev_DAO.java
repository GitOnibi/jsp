package com.dev;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dev_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Dev getDev(String dev_id, String dev_pw) throws SQLException, IOException {
		String sql = "SELECT * FROM dev WHERE dev_id = ? AND dev_pw = ?";
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:rpg");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dev_id);
			pstmt.setString(2, dev_pw);
			rs = pstmt.executeQuery();
			Dev data = null;
			if(rs.next()) {
				data = new Dev(
						rs.getString("dev_id"),
						rs.getString("dev_email")
				);
			}
			return data;
		} finally {}
	}
}
