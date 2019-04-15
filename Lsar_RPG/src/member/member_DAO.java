package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class member_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	// 계정별 테이블 만들기 
	public void create_table(String id)throws SQLException {
		
		String sql="create table "+id+" (id varchar(30), num number(3,0), type number(2,0), using number(1,0), prof number(3,0)) ";
		try {
		conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
		ptmt=conn.prepareStatement(sql);
		ptmt.executeQuery();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void get_ex(int level, int limit, int ex_p,String id) {
		String sql="update avatar set ex_now="+ex_p+" , ex_p="+limit+" , m_level="+level+" where m_id='"+id+"'";
		try {
			System.out.println("사냥 경험치업");
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//로그인 처리 계정 정보 불러오기
	public avatar_model getcharacter(String id)throws SQLException  {
		String sql="select * from avatar where m_id='"+id+"'";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			avatar_model data=null;
			if(rs.next()) {
				data=new avatar_model(
						rs.getString("m_id"),
						rs.getInt("m_level"),
						rs.getString("m_rank"),
						rs.getInt("hp"),
						rs.getInt("mp"),
						rs.getInt("dp"),
						rs.getInt("sword"),
						rs.getInt("spell"),
						rs.getInt("divine"),
						rs.getInt("fatigue"),
						rs.getString("national"),
						rs.getInt("attack"),
						rs.getInt("def"),
						rs.getInt("ex_p"),
						rs.getInt("ex_now")
					);
			}
			return data;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			rs.close();
			ptmt.close();
		}
		return null;
	}
	
	//비밀번호 변경
	public void update_pw(join_model mem) throws SQLException{
		String sql="update member set password='"+mem.getPw()+"'";
		sql+=" where member_id='"+mem.getId()+"'";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public join_model getmember_id( String id ) throws SQLException  {
		String sql="select * from member where member_id='"+id+"'";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			join_model data=null;
			if(rs.next()) {
				data=new join_model(
						rs.getString("member_id"),
						rs.getString("password"),
						rs.getString("email"),
						toDate(rs.getTimestamp("n_date"))
					);
			}
			return data;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			rs.close();
			ptmt.close();
		}
		return null;
	}
	private Date toDate(Timestamp date) {
		return date == null? null:new Date(date.getTime());
	}
	public void insert(join_model data) throws SQLException {
		String sql="insert into member values(?,?,?,?,?,?)";
		String sql2="insert into avatar(m_id) values('"+data.getId()+"')";
		conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
		try{
			ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, data.getId());
			ptmt.setString(2,data.getEmail());
			ptmt.setString(3, data.getPw());
			ptmt.setTimestamp(4, new Timestamp(data.getJ_date().getTime()));
			ptmt.setString(5,"산악마을");
			ptmt.setTimestamp(6, new Timestamp(data.getLast_date().getTime()));
			ptmt.executeQuery();
			ptmt=conn.prepareStatement(sql2);
			ptmt.executeQuery();
		}finally {}
	}
}
