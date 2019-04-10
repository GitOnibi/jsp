package com.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mob_delete_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_mob.jsp";
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mob_code = Integer.parseInt(request.getParameter("mob_code"));
		
		Mob_DAO mdao = new Mob_DAO();
		
		try {
			mdao.deleteMob(mob_code);
			String msg = "정상적으로 삭제되었습니다";
			request.setAttribute("msg", msg);
			RequestDispatcher dsp = request.getRequestDispatcher("goto_dev_mob.dev");
			dsp.forward(request, response);
			return null;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return view;
	}
}
