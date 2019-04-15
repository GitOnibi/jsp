package hunter;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;
import monster.monster;

public class hunter_handler implements main_hnd{
	private hunter_service hs = new hunter_service();
	private String view = "/lsar.jsp";
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		System.out.println("hunter");
		String noVal=req.getParameter("no");
		String num=req.getParameter("num");
		int no = Integer.parseInt(noVal);
		monster mon= hs.attack(no);
		avatar_model user=(avatar_model)req.getSession().getAttribute("User");
		hs.quest_mon(user.getId(),no,Integer.parseInt(num));
		req.setAttribute("mon", mon);
		req.setAttribute("num",num );
		req.setAttribute("part", "field");
		req.setAttribute("page", "/field_attack.jsp");
		return view;
	}

}
