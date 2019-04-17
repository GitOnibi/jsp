package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;

public class join_handler implements main_hnd {
	private String view = "/WEB-INF/member/lsar_join.jsp";
	private join_service js = new join_service();
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("join handler");
		join_param jp = new join_param();
		jp.setId(req.getParameter("id"));
		jp.setEmail(req.getParameter("email"));
		jp.setPw(req.getParameter("pw"));
		jp.setCmp_pw(req.getParameter("pw_cmp"));
		
		Map<String,Boolean> err = new HashMap<>();
		req.setAttribute("err", err);
		
		jp.value_empty(err);
		if(!err.isEmpty())
			return view;
		try {
			js.join(jp);
			return "/WEB-INF/member/lsar_login.jsp";
		}catch(Exception e) {
			return view;
		}
	}
}
