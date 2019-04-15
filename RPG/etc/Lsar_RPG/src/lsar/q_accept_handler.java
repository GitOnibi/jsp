package lsar;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsar.dao.quest_DAO;
import main_cnt.main_hnd;
import member.avatar_model;

public class q_accept_handler  implements main_hnd{

	private quest_DAO q_dao =new quest_DAO();
	private String view = "/lsar.jsp";
	
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		String q_n = req.getParameter("q_num");
		String t_c = req.getParameter("t_code");
		String cnt = req.getParameter("cnt");
		avatar_model user=(avatar_model)req.getSession().getAttribute("User");
		req.setAttribute("part", "que");
		req.setAttribute("page", "/quest_main.jsp");
		if(t_c==null || t_c.isEmpty()) {
			int q_num=Integer.parseInt(q_n);
			int count = Integer.parseInt(cnt);
			if(!q_dao.recpt_quest(user.getId(),q_num,count)) {
				//미션 미완료시
			}
		}else {
			int q_num=Integer.parseInt(q_n);
			int t_code = Integer.parseInt(t_c);
			int count = Integer.parseInt(cnt);
			q_dao.set_quest(user.getId(), q_num, t_code,count);
		}
		res.sendRedirect(req.getContextPath()+"/quest.ls");
		return null;
	}
}
