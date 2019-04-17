package info;

import java.sql.SQLException;

public class notice_read_service {
	private notice_DAO n_dao = new notice_DAO();
	private notice_cont_DAO nc_dao=new notice_cont_DAO();
	
	public notice_data getnotice(int no, boolean read_cnt,String id) throws SQLException {
		notice n_data = n_dao.select_title(no);
		notice_content nc_data = nc_dao.select_cont(no);
		if(n_data.getWriter().equals(id))read_cnt=false;
		if(read_cnt) {
			n_dao.increaseCnt(no);
		}
		return new notice_data(n_data,nc_data);
	}
}
