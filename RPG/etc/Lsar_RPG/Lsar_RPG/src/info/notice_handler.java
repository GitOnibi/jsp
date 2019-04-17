package info;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class notice_handler implements main_hnd{
	private static final String view="/lsar.jsp";
	private notice_list_service nls= new notice_list_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException{
		
		String pageVal = req.getParameter("page_no");
		int pageNo=1;
		if(pageVal!=null)
			pageNo=Integer.parseInt(pageVal);
		notice_page n_page = nls.getpage(pageNo);
		req.setAttribute("notice_page", n_page);
		
		req.setAttribute("part", "lsar_notice");
		req.setAttribute("page", "/lsar_notice_main.jsp");
		
		return view;
	}
}
