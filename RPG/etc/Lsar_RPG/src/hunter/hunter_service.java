package hunter;

import java.sql.SQLException;

import monster.monster;
import monster.monster_dao;

public class hunter_service {
	private monster_dao m_dao= new monster_dao();
	
	public monster attack(int no) throws SQLException {
		monster mon = m_dao.attack_mon(no);
		if(mon==null)
			return null;
		
		return mon;
	}
}
