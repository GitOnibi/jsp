package member;

import java.sql.SQLException;
import java.util.Date;

public class join_service {
	private member_DAO mem_dao = new member_DAO();
	public void dup_check(String id ) throws SQLException {
		join_model data=mem_dao.getmember_id(id);
		if(data!=null) {
			throw new RuntimeException();
		}
	}
	public void join(join_param jparam) {
		try {
			join_model data=mem_dao.getmember_id(jparam.getId());
			if(data ==null) {
				mem_dao.create_table(jparam.getId());
				mem_dao.insert(
					new join_model(
							jparam.getId(),
							jparam.getPw(),
							jparam.getEmail(),
							new Date()
							)
					);
				
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
