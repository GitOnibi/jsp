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
		System.out.println("- Login_handler action");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			Map<String, Boolean> empty_ck = new HashMap<>();
			
			if(id == null || id.isEmpty()) {
				empty_ck.put("empty_id", Boolean.TRUE);
			}
			
			if(pw == null || pw.isEmpty()) {
				empty_ck.put("empty_pw", Boolean.TRUE);
			}
			
			if(empty_ck.isEmpty()) {
				return view;
			}
			
			request.setAttribute("empty_ck", empty_ck);
			
			try {
				User user = ls.login(id, pw);
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return null;
			} catch(RuntimeException e) {
				empty_ck.put("exception", Boolean.TRUE);
				return view;
			}
		}
		return view;
	}
}
