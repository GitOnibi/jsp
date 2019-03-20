package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Join_param;
import com.service.Join_service;

public class Member_join_handler implements Main_handler {
	private String view = "/WEB-INF/view/member_join.jsp";
	Join_service js = new Join_service();
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Join_handler action");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String user_id		= request.getParameter("user_id");
			String user_pw		= request.getParameter("user_pw");
			String user_pw_cnf	= request.getParameter("user_pw_cnf");
			String user_email	= request.getParameter("user_email");
			
			Join_param jp = new Join_param();
			jp.setUser_id(user_id);
			jp.setUser_pw(user_pw);
			jp.setUser_pw_cnf(user_pw_cnf);
			jp.setUser_email(user_email);
			
			try {
				js.join(jp);
				return "/WEB-INF/view/member_join_ok.jsp";
			} catch(RuntimeException e) {
				return view;
			}
		}
		return view;
	}
}
