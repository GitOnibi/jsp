package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Login_service;
import com.bean.User;

public class Member_login_handler implements Main_handler {
	private String view = "/WEB-INF/view/member_login.jsp";
	Login_service ls = new Login_service();
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Member_login_handler action");
		
		if(request.getMethod().equalsIgnoreCase("GET"))  return view;
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			try {
				User user = ls.login(user_id, user_pw);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("character_select.do");
				return null;
			} catch(RuntimeException e) { return view; }
		}
		return view;
	}
}
