package monster;

import java.sql.SQLException;
import java.util.List;

public class monster_filed_service {
	private monster_dao mon_dao = new monster_dao();
	
	public List<monster> get_monster_list(int no) throws SQLException {
		List<monster> data=null;
		data=mon_dao.select_field_mon(no);
		if(data!=null)
			return data;
		else
		{
			System.out.println("몬스터없음");
			return null;
		}
	}
}
