package skill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.user_model;

public class skill_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	public boolean update_use(int code,String id,int use) {
		String sql="update "+id+" set using="+use+" where id="+code;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			System.out.println(sql);
			int cnt=ptmt.executeUpdate();
			if(cnt>0)
				return true;
			return false;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public skill_tree getskillList(Object o_code) throws SQLException{
		System.out.println("skill_get");
		user_model code = (user_model) o_code;
		String sql="select * from skill where code="+code.getId();
		System.out.println(sql);
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				skill_tree data=new skill_tree(
						code.getId(),
						rs.getString("skill_name"),
						rs.getString("skill_type"),
						rs.getString("skill_kind"),
						rs.getInt("skill_option1"),
						rs.getInt("skill_option2"),
						rs.getInt("skill_option3"),
						rs.getInt("skill_option4"),
						code.getUsing()==1?"해제":"장착"
						);
				System.out.println("dao"+data.getName());
				return data;
			}
			
			}catch(SQLException e) {
				System.out.println("getskill"+e);
			}finally {
				rs.close();
				ptmt.close();
			}
		return null;
	}
	public List<user_model> getcode(String id) throws SQLException{
		System.out.println("code get");
		List<user_model> list = new ArrayList<user_model>();
		String sql="select * from "+id+" where type=1";
		System.out.println(sql);
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			while(rs.next()) {
				user_model data = new user_model();
				data.setId(rs.getInt("id"));
				data.setNum(rs.getInt("num"));
				data.setType(rs.getInt("type"));
				data.setUsing(rs.getInt("using"));
				data.setProf(rs.getInt("prof"));
				list.add(data);
			}
			return list;
		}catch(SQLException e) {
			System.out.println("getcode"+e);
		}finally {
			rs.close();
			ptmt.close();
		}
		return null;
	}
}
