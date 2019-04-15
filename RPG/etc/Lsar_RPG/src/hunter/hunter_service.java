package hunter;

import java.sql.SQLException;

import lsar.dao.quest_DAO;
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
	public void quest_mon(String id,int no, int num) throws SQLException {
		quest_DAO q_dao=new quest_DAO();
		System.out.println(no);
		q_dao.quest_mon(id,no,num);
	}
}
