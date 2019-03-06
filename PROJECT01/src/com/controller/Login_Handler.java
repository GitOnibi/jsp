package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.Login_service;

public class Login_Handler implements Main_Handler{
	private String view = "/WEB-INF/show/login.jsp";
	private Login_service ls = new Login_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Login_Handler action");
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			Map<String, Boolean> err = new HashMap<String, Boolean>();
			request.setAttribute("err", err);
			
			if(id == null || id.isEmpty()) {
				err.put("id", Boolean.TRUE);
			}
			if(password == null || password.isEmpty() ) {
				err.put("password", Boolean.TRUE);
			}
			if(!err.isEmpty()) {
				return view;
			}
			try {
				User data = ls.login(id, password);
				request.getSession().setAttribute("user", data);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return null;
			} catch(RuntimeException e) {
				err.put("NotMatch", Boolean.TRUE);
				return view;
			}
		}
		return view;
	}
}
