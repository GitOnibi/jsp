package info;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class notice_read_handler implements main_hnd{
	private notice_read_service nrs = new notice_read_service();

	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException{
		String noval = req.getParameter("no");
		int ntnum =Integer.parseInt(noval);
		// id 얻어오기
		avatar_model user=(avatar_model)req.getSession().getAttribute("User");
		String id= user.getId();
		try {
			notice_data data = nrs.getnotice(ntnum, true,id);
			req.setAttribute("data", data);
			req.setAttribute("part", "lsar_notice");
			req.setAttribute("page", "/lsar_notice_view.jsp");
			
			return "/lsar.jsp";
		}catch(Exception e) {
			
			
		}
		return null;
	}
}






