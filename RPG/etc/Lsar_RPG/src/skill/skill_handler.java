package skill;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class skill_handler implements main_hnd{
	private String view = "/lsar.jsp";
	private skill_service ss = new skill_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException{
			avatar_model data;
			System.out.println("skill handler");
			
			data=(avatar_model)req.getSession().getAttribute("User");
			System.out.println(data.getId());
			try {
				List<skill_tree> list=ss.getuserskill(data.getId());
				System.out.println("aa"+list.get(0).getName());
				req.setAttribute("skill", list);
			}catch(RuntimeException e) {
				//error.put("notMatch", Boolean.TRUE);
				System.out.println("skillhandler"+e);
						
				return view;
			}
			/*Map<String, Boolean> error=new HashMap<>();
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
			}*/
		req.setAttribute("part", "skill");
		req.setAttribute("page", "/skill_main.jsp");
		return view;
	}
}