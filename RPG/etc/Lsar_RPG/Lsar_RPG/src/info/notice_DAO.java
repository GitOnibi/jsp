package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class notice_DAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ptmt;
	
	public int update_notice(int no, String title) {
		String sql="update notice set title='"+title+"' , moddate=now() where num="+no;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			return ptmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
	public notice select_title(int no) {
		String sql="select * from notice where num="+no;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			rs=ptmt.executeQuery();
			notice data=null;
			if(rs.next()) {
				data=new notice(
						rs.getInt("num"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("regdate"),
						rs.getDate("moddate"),
						rs.getInt("read_cnt")
						);
				return data;
			}
		}catch(SQLException e) {
			throw new RuntimeException("select title"+e);
		}
		return null;
	}
	public void increaseCnt(int no) {
		String sql="update notice set read_cnt=read_cnt+1 where num="+no;
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
		}catch(SQLException e) {
			throw new RuntimeException("select title"+e);
		}
	}
	
	public List<notice> select_notice(int start, int size) throws SQLException{
		String sql="select * from(select rownum as rn, a.* ";
		sql +="from(select * from notice order by num desc) a) ";
		sql +="where rn between "+start+" and "+(size+start);
		try {
			System.out.println(sql);
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			
			rs=ptmt.executeQuery();
			List<notice> data = new ArrayList<notice>();
			while(rs.next()) {
				notice tmp=new notice(
						rs.getInt("num"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("regdate"),
						rs.getDate("moddate"),
						rs.getInt("read_cnt")
						);
				data.add(tmp);
			}
			return data;
		}catch(SQLException e) {
			throw new RuntimeException("table sel "+e);
		}finally {
			conn.close();
		}
	}
	public int select_Cnt() throws SQLException {
		Statement stmt=null;
		String sql="select count(*) from notice";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}catch(SQLException e) {
			throw new RuntimeException("notice count "+e);
		}finally {
			conn.close();
		}
	}
	public int getnum() {
		int num=1;
		try {
			String sql="select max(num) as mnum from notice";
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
	public notice insert(notice data) throws SQLException {
		String sql="insert into notice(num,writer_id,title,regdate,moddate,read_cnt)";
		sql+=" values(?,?,?,?,?,0)";
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:jkr");
			ptmt=conn.prepareStatement(sql);
			ptmt.setInt(1, data.getNumber());
			ptmt.setString(2, data.getWriter());
			ptmt.setString(3, data.getTitle());
			ptmt.setTimestamp(4, toTimestamp(data.getRegdate()));
			ptmt.setTimestamp(5, toTimestamp(data.getModifiedDate()));
			int insert_cnt=ptmt.executeUpdate();
			if(insert_cnt>0) {
				Statement stmt = conn.createStatement();
				String sql1 ="select * from notice order by num desc";
				rs=stmt.executeQuery(sql1);
				if(rs.next()) {
					int number= rs.getInt("num");
					return new notice(
				number, rs.getString("writer_id"),
				rs.getString("title"),
				rs.getDate("regdate"),
				rs.getDate("moddate"),0
							);
				}
			}
			return null;
		}finally{
			conn.close();
		}
	}
	private Date toDate(Timestamp time) {
		return new Date(time.getTime());
	}
	private Timestamp toTimestamp(Date date) {
		// TODO Auto-generated method stub
		return new Timestamp(date.getTime());
	}
}
