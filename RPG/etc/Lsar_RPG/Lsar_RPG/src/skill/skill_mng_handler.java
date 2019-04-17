package skill;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;
import member.avatar_model;

public class skill_mng_handler implements main_hnd{
	private String view = "/skill.ls";
	private skill_mng_service sms = new skill_mng_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException{
			
			System.out.println("skill mng handler");
			avatar_model data;
			data=(avatar_model)req.getSession().getAttribute("User");
			
			int code=Integer.parseInt(req.getParameter("cd"));
			int use=req.getParameter("us").equals("해제") ? 0 :1;
			if(sms.Update_Using(code,data.getId(),use)) {
				res.sendRedirect(req.getContextPath()+"/skill.ls");
				return null;
			}
		return view;
	}
}