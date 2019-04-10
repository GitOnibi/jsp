package com.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mob_insert_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_mob.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Mob_insert_handler action");
		if(request.getMethod().equalsIgnoreCase("GET")) { return view; }
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			int mob_code	= Integer.parseInt(request.getParameter("mob_code"));
			String mob_name	= request.getParameter("mob_name");
			int mob_lv		= Integer.parseInt(request.getParameter("mob_lv"));
			int mob_str		= Integer.parseInt(request.getParameter("mob_str"));
			int mob_dex		= Integer.parseInt(request.getParameter("mob_dex"));
			int mob_prop	= Integer.parseInt(request.getParameter("mob_prop"));
			int mob_sk1		= Integer.parseInt(request.getParameter("mob_sk1"));
			int mob_sk2		= Integer.parseInt(request.getParameter("mob_sk2"));
			int mob_sk3		= Integer.parseInt(request.getParameter("mob_sk3"));
			String mob_sub	= request.getParameter("mob_sub");
			int mob_atk		= Integer.parseInt(request.getParameter("mob_atk"));
			int mob_def		= Integer.parseInt(request.getParameter("mob_def"));
			int mob_hp		= Integer.parseInt(request.getParameter("mob_hp"));
			int mob_exp		= Integer.parseInt(request.getParameter("mob_exp"));
			
			Mob_DAO mdao = new Mob_DAO();
			
			try {
				Mob_bean mb = new Mob_bean(mob_code, mob_name, mob_lv, mob_str, mob_dex, mob_prop, mob_sk1, mob_sk2, mob_sk3, mob_sub, mob_atk, mob_def, mob_hp, mob_exp);
				mdao.setMob(mb);
				String msg = "정상적으로 등록되었습니다";
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
