package com.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mob_modify_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_mob.jsp";
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) { return view; }
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			int mob_code	= Integer.parseInt(request.getParameter("mob_code"));
			String mob_name	= request.getParameter("mob_name");
			int mob_lv		= Integer.parseInt(request.getParameter("mob_lv"));
			int mob_str		= Integer.parseInt(request.getParameter("mob_str"));
			int mob_dex		= Integer.parseInt(request.getParameter("mob_dex"));
			int mob_prop	= Integer.parseInt(request.getParameter("mob_prop"));
			int mob_opt1	= Integer.parseInt(request.getParameter("mob_opt1"));
			int mob_opt2	= Integer.parseInt(request.getParameter("mob_opt2"));
			int mob_opt3	= Integer.parseInt(request.getParameter("mob_opt3"));
			int mob_opt4	= Integer.parseInt(request.getParameter("mob_opt4"));
			int mob_opt5	= Integer.parseInt(request.getParameter("mob_opt5"));
			int mob_sk1		= Integer.parseInt(request.getParameter("mob_sk1"));
			int mob_sk2		= Integer.parseInt(request.getParameter("mob_sk2"));
			int mob_sk3		= Integer.parseInt(request.getParameter("mob_sk3"));
			int mob_sk4		= Integer.parseInt(request.getParameter("mob_sk4"));
			int mob_sk5		= Integer.parseInt(request.getParameter("mob_sk5"));
			String mob_sub	= request.getParameter("mob_sub");
			int mob_atk		= Integer.parseInt(request.getParameter("mob_atk"));
			int mob_def		= Integer.parseInt(request.getParameter("mob_def"));
			int mob_hp		= Integer.parseInt(request.getParameter("mob_hp"));
			
			Mob_DAO mdao = new Mob_DAO();
			
			try {
				Mob_bean mb = new Mob_bean(mob_code, mob_name, mob_lv, mob_str, mob_dex, mob_prop, mob_opt1, mob_opt2, mob_opt3, mob_opt4, mob_opt5, mob_sk1, mob_sk2, mob_sk3, mob_sk4, mob_sk5, mob_sub, mob_atk, mob_def, mob_hp);
				mdao.modifyMob(mb);
				String msg = "정상적으로 수정되었습니다";
				request.setAttribute("msg", msg);
				RequestDispatcher dsp = request.getRequestDispatcher("goto_dev_mob.dev");
				dsp.forward(request, response);
				return null;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return view;
	}
}
