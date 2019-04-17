package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;


public class idcheck_handler implements main_hnd {
	private String view = "/WEB-INF/member/lsar_join.jsp";
	private join_service js = new join_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("idcheck handler");
		join_param jp = new join_param();
		jp.setId(req.getParameter("id"));
		
		Map<String,Boolean> err = new HashMap<>();
		req.setAttribute("err", err);
		System.out.println(req.getParameter("id"));
		try {
			js.dup_check(jp.getId());
			err.put("dup",Boolean.FALSE);
		}catch(Exception e) {
			err.put("dup",Boolean.TRUE);
		}
		return view;
	}
}