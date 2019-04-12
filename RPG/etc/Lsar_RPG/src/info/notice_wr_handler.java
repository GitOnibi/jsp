package info;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class notice_wr_handler  implements main_hnd{
	private static final String view="/lsar.jsp";
	private notice_service ns = new notice_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException{
		req.setAttribute("part", "lsar_notice");
		
		Map<String,Boolean> error = new HashMap<>();
		req.setAttribute("error", error);
		
		avatar_model data=(avatar_model)req.getSession().getAttribute("User");
		write_param wp= new write_param(data.getId(),req.getParameter("title"),req.getParameter("cont"));
		wp.validate(error);
		
		
		if(!error.isEmpty()) {
			req.setAttribute("page", "/lsar_notice_write.jsp");
			return view;
		}
		int num = ns.wrtie(wp);
		res.sendRedirect(req.getContextPath()+"/inn.do");
		return null;
		//req.setAttribute("notice_num", num);
		//req.setAttribute("page", "/lsar_notice_main.jsp");
		//return view;
	}
}
