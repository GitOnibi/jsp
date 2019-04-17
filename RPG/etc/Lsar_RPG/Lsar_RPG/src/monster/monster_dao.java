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
	
	public int getnum(String id) {
		int num=1;
		try {
			String sql="select max(num) as mnum from "+id;
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt("mnum")+1;
				return num;
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		return num;
	}
	
	public void get_equip(String i_list, List<Integer> item,String id) throws SQLException {
		String[] list=i_list.split("-");
		System.out.println(list[0]);
		System.out.println(list[1]);
		if(item!=null) {
			for(int i=0; i<item.size();i++) {
				int item_code=0;
				if(item.get(i)==10) {
					item_code=Integer.parseInt(list[1]);
				}
				if(item.get(i)>=4 && item.get(i) <=6) {
					item_code=Integer.parseInt(list[0]);
				}
				if(item_code!=0) {
					int num=getnum(id);
					String sql="insert into "+id+"(id,num,type,using,prof,achive)";
					sql+=" values("+item_code+","+num+",2,0,0,0)";
					try {
						conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
						ptmt=conn.prepareStatement(sql);
						ptmt.executeUpdate();
					}catch(SQLException e) {
						throw new RuntimeException("attack_dao "+e);
					}finally {
						conn.close();
					}
				}
			}
		}
	}
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
