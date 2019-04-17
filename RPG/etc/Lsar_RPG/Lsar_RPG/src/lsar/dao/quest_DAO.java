package lsar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lsar.model.quest_model;
import member.avatar_model;
import member.member_DAO;

public class quest_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	public void quest_mon(String id,int no, int num) throws SQLException {
		String sql="update "+id+" set achive=achive+"+num;
		sql += " where type=3 and using="+no;
		System.out.println(sql);
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("quest_mon " + e);
		}finally {
			conn.close();
		}
	}
	public void recp_my(String id,int num) throws SQLException{
		String sql="delete from "+id+" where id="+num;
		System.out.println(sql);
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("recpt_quest " + e);
		}finally {
			conn.close();
		}
	}
	public boolean recpt_quest(String id, int q_num,int cnt) throws SQLException {
		String sql ="select * from quest where num="+q_num;
		member_DAO m_dao=new member_DAO();
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				System.out.println("퀘스트 수령");
				if(rs.getInt("q_count")>cnt)
					return false;
				int r_code=rs.getInt("reward_code");
				if(r_code==0) {
					//경험지 지급
					System.out.println("r_code 0");
					avatar_model data=m_dao.getcharacter(id);
					m_dao.incre_ex(rs.getInt("reward"),data);
					recp_my(id,q_num);
				}
				if(r_code==1) {
					//아이템지급
				}
				return true;
			}
		}catch(SQLException e) {
			System.out.println("recpt_quest " + e);
		}finally {
			conn.close();
			rs.close();
		}
		return false;
	}
	
	public List<quest_model> getMy_quest(String id) throws SQLException{
		List<quest_model> data=new ArrayList<quest_model>();
		String sql ="select * from quest a, "+id+" b  where a.num=b.id and b.type=3";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			while (rs.next()) {
				quest_model tmp= new quest_model(
						rs.getInt("num"),rs.getString("title"),
						rs.getString("cont"),rs.getInt("q_level"),
						rs.getInt("q_count"),rs.getInt("type_code"),
						rs.getString("type"),rs.getInt("reward_code"),
						rs.getInt("reward"),rs.getInt("achive")
						);
				data.add(tmp);
			}
			return data;
		}catch(SQLException e) {
			System.out.println("getMy_quest " + e);
		}finally {
			conn.close();
			rs.close();
		}
		return null;
	}
	
	
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
	
	
	public void set_quest(String id,int q_num, int t_code, int count) throws SQLException {
		int num=getnum(id);
		String sql="insert into "+id+"(id,num,type,using,prof,achive) ";
		sql+=" values("+q_num+","+num+",3,"+t_code+","+count+",0)";
		System.out.println(sql);
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeQuery();
		}catch(SQLException e) {
			System.out.println("set_ quest " + e);
		}finally {
			conn.close();
		}
	}
	public Map<Integer,quest_model>  get_questall(List<quest_model> my) throws SQLException {
		String sql="select * from quest";
		Map<Integer,quest_model> quest = new HashMap<Integer,quest_model>();
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			Map<Integer,Boolean>my_map=new HashMap<>();
			for(quest_model qm:my) {
				System.out.println(qm.getNum());
				my_map.put(qm.getNum(), Boolean.TRUE);
			}
			while(rs.next()) {
				int num=rs.getInt("num");
				System.out.println(my_map.get(num));
				if(my_map.get(num)==null) {
					quest_model temp = new quest_model(
							num,rs.getString("title"),
							rs.getString("cont"),rs.getInt("q_level"),
							rs.getInt("q_count"),rs.getInt("type_code"),
							rs.getString("type"),rs.getInt("reward_code"),
							rs.getInt("reward")
							);
					quest.put(temp.getNum(), temp);
				}
			}
			return quest;
		}catch(SQLException e) {
			System.out.println("get_quest all " + e);
		}finally {
			conn.close();
			rs.close();
		}
		return null;
	}
}
