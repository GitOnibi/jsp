package member;

import java.sql.SQLException;


public class login_service {
private member_DAO mem_dao = new member_DAO();
	
	public avatar_model login(String id, String pw) {
		try {
			System.out.println("로그인 시도");
			avatar_model data=new avatar_model();
			join_model mb = mem_dao.getmember_id(id);
			if(mb==null) {
				throw new RuntimeException();
			}
			if(!mb.MatchPW(pw)) {
				throw new RuntimeException();
			}
			System.out.println("로그이 완료");
			data=mem_dao.getcharacter(id);
			return data;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
