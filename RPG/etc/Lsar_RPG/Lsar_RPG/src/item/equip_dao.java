package item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class equip_dao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	
	public boolean Update_Using(int code, String id, int use) throws SQLException {
		String sql =" update "+id+" set using="+use+" where num="+code+" and type=2";
		try {
		conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
		ptmt=conn.prepareStatement(sql);
		ptmt.executeUpdate();
		return true;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			conn.close();
		}
		return false;
	}
	
	
	public List<equip_model> get_myItem(String id) throws SQLException{
		List<equip_model> data = new ArrayList<equip_model>();
		String sql="select * from equip a, "+id+" b where a.code=b.id and b.type=2";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			while(rs.next()) {
				equip_model tmp = new equip_model(
						rs.getInt("code"),rs.getString("equip_name"),
						rs.getString("equip_type"),rs.getInt("equip_option1"),
						rs.getInt("equip_option2"),rs.getInt("equip_option3"),
						rs.getInt("equip_option4"),rs.getString("equip_part"),
						rs.getInt("type"),rs.getInt("using")==0?"장착":"해제",rs.getInt("prof"),
						rs.getInt("achive"),rs.getInt("num")
						);
				data.add(tmp);
			}
			return data;
		}catch(SQLException e) {
			System.out.println("get_myItem " + e);
		}finally {
			conn.close();
			rs.close();
		}
		return null;
	}
}
