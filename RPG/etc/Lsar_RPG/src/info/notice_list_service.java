package info;

import java.sql.SQLException;
import java.util.List;

public class notice_list_service {
	private notice_DAO n_dao=new notice_DAO();
	private int size =10;
	
	public notice_page getpage(int pagenum) {
		try {
			int total=n_dao.select_Cnt();
			List<notice> cont = n_dao.select_notice((pagenum-1)*size+(pagenum>1?1:0),size );
			return new notice_page(total,pagenum,size,cont);
			
		}catch(SQLException e) {
			throw new RuntimeException("notice list srvice "+e);
		}
	}
}
