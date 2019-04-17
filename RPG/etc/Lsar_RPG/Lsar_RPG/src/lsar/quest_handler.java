package lsar;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsar.dao.quest_DAO;
import lsar.model.quest_model;
import main_cnt.main_hnd;
import member.avatar_model;
import monster.monster;
import monster.monster_dao;

public class quest_handler  implements main_hnd{
	private quest_DAO q_dao = new quest_DAO();
	private String view = "/lsar.jsp";
	private monster_dao m_dao=new monster_dao();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		avatar_model user=(avatar_model)req.getSession().getAttribute("User");
		List<quest_model> my_Q = q_dao.getMy_quest(user.getId());
		Map<Integer,quest_model> quest = q_dao.get_questall(my_Q);
		Map<Integer,String> mon = new HashMap<Integer,String>();
				
		Iterator<Integer> it = quest.keySet().iterator();
		while(it.hasNext()) {
			int key= it.next();
			monster tmp=m_dao.attack_mon(quest.get(key).getType_code());
			mon.put(tmp.getNum(),tmp.getMon_name());
		}
		
		req.setAttribute("my_q", my_Q);
		req.setAttribute("mon", mon);
		req.getSession().setAttribute("quest", quest);
		req.setAttribute("part", "que");
		req.setAttribute("page", "/quest_main.jsp");
		return view;
	}
}
