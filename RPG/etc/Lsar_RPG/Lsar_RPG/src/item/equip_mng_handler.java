package item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class equip_mng_handler implements main_hnd{
	private String view = "/equip.ls";
	private equip_dao e_dao=new equip_dao();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		System.out.println("equip_mng");
		avatar_model user =(avatar_model)req.getSession().getAttribute("User");
		int code=Integer.parseInt(req.getParameter("cd"));
		int use=req.getParameter("us").equals("해제") ? 0 :1;
		if(e_dao.Update_Using(code,user.getId(),use)) {
			res.sendRedirect(req.getContextPath()+"/equip.ls");
			return null;
		}
		return view;
	}
}