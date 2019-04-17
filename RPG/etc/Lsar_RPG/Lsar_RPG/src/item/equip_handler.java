package item;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class equip_handler implements main_hnd{
	private String view = "/lsar.jsp";
	private equip_dao e_dao=new equip_dao();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		System.out.println("equip");
		avatar_model user =(avatar_model)req.getSession().getAttribute("User");
		List<equip_model> my_item=e_dao.get_myItem(user.getId());
		req.setAttribute("item", my_item);
		req.setAttribute("part", "equip");
		req.setAttribute("page", "/equip_main.jsp");
		return view;
	}
}