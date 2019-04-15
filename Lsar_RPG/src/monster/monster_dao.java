package monster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class monster_dao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	public monster attack_mon(int no) throws SQLException {
		String sql="select * from monster where num ="+no;
		System.out.println("어택");
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery(sql);
			if(rs.next()) {
				monster mon= new monster(
						rs.getInt("num"), rs.getString("mon_name"),
						rs.getInt("mon_level"),rs.getInt("attack"),
						rs.getInt("def"),rs.getInt("hp"),
						rs.getInt("mp"),rs.getInt("dp"),
						rs.getString("kind"),rs.getString("item_list"),
						rs.getInt("field_num")
						);
				return mon;
			}
		}catch(SQLException e) {
			throw new RuntimeException("attack_dao "+e);
		}finally {
			conn.close();
		}
		return null;
	}
	
	public List<monster> select_field_mon(int no) throws SQLException {
		String sql="select * from monster where field_num ="+no;
		List<monster> data = new ArrayList<monster>();
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery(sql);
			while(rs.next()) {
				monster temp=new monster(
						rs.getInt("num"), rs.getString("mon_name"),
						rs.getInt("mon_level"),rs.getInt("attack"),
						rs.getInt("def"),rs.getInt("hp"),
						rs.getInt("mp"),rs.getInt("dp"),
						rs.getString("kind"),rs.getString("item_list"),
						rs.getInt("field_num")
						);
				data.add(temp);
			}
			return data;
		}catch(SQLException e) {
			System.out.println("select field mon "+e);
		}finally {
			conn.close();
		}
		return null;
	}
}
