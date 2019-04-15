package skill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import member.user_model;

public class skill_service {
	private skill_DAO s_dao = new skill_DAO();
	
	public List<skill_tree> getuserskill(String id) throws SQLException{
		System.out.println("skill_service");
		List<skill_tree> list = new ArrayList<skill_tree>();
		try {
			List<user_model> code_list = s_dao.getcode(id);
			Iterator it = code_list.iterator();
			while(it.hasNext()) {
				list.add(s_dao.getskillList(it.next()));
			}
			System.out.println("service"+list.get(0).getName());
			return list;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
