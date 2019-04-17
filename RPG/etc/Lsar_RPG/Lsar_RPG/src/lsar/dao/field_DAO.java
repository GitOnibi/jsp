package lsar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lsar.model.field_model;
import lsar.model.field_national;

public class field_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	
	public List<field_national> select_national(){
		String sql = "select distinct field_national from field";
		List<field_national> data = new ArrayList<>();
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery(sql);
			while(rs.next()) {
				field_national temp = new field_national(
						null,
						rs.getString("field_national")
						);
				System.out.println(temp.getNational());
				data.add(temp);
			}
			return data;
		}catch(SQLException e) {
			throw new RuntimeException("select_national "+e);
		}
	}
	
	public void select_all(field_national fdata) {
		String sql="select * from field where field_national='"+fdata.getNational()+"'";
		List<field_model> data = new ArrayList<>();
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery(sql);
			System.out.println(sql);
			System.out.println("field_dao");
			while(rs.next()) {
				field_model tmp = new field_model(
						rs.getInt("num"),
						rs.getString("field_name"),
						rs.getInt("field_level"),
						rs.getString("field_national")
						);
				System.out.println(tmp.getField_name());
				data.add(tmp);
			}
			fdata.setName(data);
		}catch(SQLException e) {
			throw new RuntimeException("select_all "+e);
		}
	}
}
