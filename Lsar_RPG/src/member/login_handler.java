package member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;


public class login_handler implements main_hnd {
	private String view = "/WEB-INF/member/lsar_login.jsp";
	private login_service ls = new login_service();
	
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getSession().getAttribute("User")==null) {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		if(req.getMethod().equalsIgnoreCase("POST")) {
			
			System.out.println("login handler");
			String id= req.getParameter("lsar_id");
			String pw = req.getParameter("lsar_pw");
			
			Map<String, Boolean> error=new HashMap<>();
			req.setAttribute("error", error);
			
			if(id==null || id.isEmpty())
				error.put("id", Boolean.TRUE);
			if(pw==null || pw.isEmpty())
				error.put("pw", Boolean.TRUE);
			if(!error.isEmpty())
				return view;
			try {
				avatar_model data = ls.login(id, pw);
				req.getSession().setAttribute("User", data);
				res.sendRedirect(req.getContextPath());
				return null;
			}catch(RuntimeException e) {
				error.put("notMatch", Boolean.TRUE);
				return view;
			}
		}
		return view;
		}else {
			res.sendRedirect(req.getContextPath());
			return null;
		}
	}
}
