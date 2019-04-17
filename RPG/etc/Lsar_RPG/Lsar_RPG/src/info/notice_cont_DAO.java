package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class notice_cont_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	
	public int update_cont(int no, String cont) {
		String sql="update notice_content set cont='"+cont+"' where num="+no;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			return ptmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public notice_content select_cont(int no) {
		String sql="select * from notice_content where num="+no;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			notice_content data=null;
			if(rs.next()) {
				data=new notice_content(
						rs.getInt("num"),
						rs.getString("cont")
						);
				return data;
			}
		}catch(SQLException e) {
			throw new RuntimeException("cont select title "+e);
		}
		return null;
	}
	
	public notice_content insert(notice_content data) throws SQLException {
		String sql="insert into notice_content(num,cont)";
		sql+=" values(?,?)";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, data.getNumber());
			ptmt.setString(2, data.getContent());
			int insert_cnt=ptmt.executeUpdate();
			if(insert_cnt>0)
				return data;
			else
				return null;
		}finally {
			conn.close();
		}
		
	}
}
