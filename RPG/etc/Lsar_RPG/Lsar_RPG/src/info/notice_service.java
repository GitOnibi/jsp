package info;

import java.sql.SQLException;
import java.util.Date;

public class notice_service {
	private notice_DAO n_dao = new notice_DAO();
	private notice_cont_DAO nc_dao=new notice_cont_DAO();
	
	public int wrtie(write_param req) {
		try {
			notice data = toNotice(req);
			notice save = n_dao.insert(data);
			if(save==null) {
				throw new RuntimeException("저장실패");
			}
			System.out.println(save.getNumber());
			notice_content cont = new notice_content(save.getNumber(),req.getContent());
			notice_content save_cont= nc_dao.insert(cont);
			if(save_cont==null) {
				throw new RuntimeException("글내용 저장실패");
			}
			return save.getNumber();
		}catch(SQLException e) {
			throw new RuntimeException("notice service"+e);
		}
	}
	
	public notice toNotice(write_param req) {
		Date now = new Date();
		return new notice(n_dao.getnum(),req.getWriter(),req.getTitle(),now,now,0);
	}
}
