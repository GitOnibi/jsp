package lsar;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsar.model.field_national;
import lsar.service.field_service;
import main_cnt.main_hnd;
import member.avatar_model;
import member.login_service;
import monster.monster;
import monster.monster_filed_service;

public class field_sel_handler implements main_hnd{
	private String view = "/lsar.jsp";
	private monster_filed_service mfs = new monster_filed_service();
	private login_service ls = new login_service();
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		System.out.println("field_sel");
		req.setAttribute("part", "field");
		String noVal = req.getParameter("no");
		if(noVal==null || noVal.isEmpty()) {
			req.setAttribute("page", "/field_main.jsp");
		}else {
			int num=Integer.parseInt(noVal);
			List<monster> data=mfs.get_monster_list(num);
			avatar_model user =(avatar_model)req.getSession().getAttribute("User");
			user=ls.login(user.getId());
			req.getSession().setAttribute("User", user);
			req.setAttribute("list", data);
			req.setAttribute("page", "/field_monster.jsp");
		}
		return view;
	}
}
