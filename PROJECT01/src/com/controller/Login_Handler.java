package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.User_param;
import com.service.User_service;

public class Login_Handler implements Main_Handler {
	private String view = "/WEB-INF/index.jsp";
	User_service us = new User_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_param up = new User_param();
		up.setId(request.getParameter("id"));
		up.setName(request.getParameter("name"));
		
		Map<String, Boolean> err = new HashMap<String, Boolean>();
		request.setAttribute("err", err);
		up.value_empty(err);
		if(!err.isEmpty()) {
			return view;
		}
		try {
			us.login(up);
			return "/WEB-INF/show/login_ok.jsp";
		} catch(Exception e) {
			err.put("dup", Boolean.TRUE);
			return view;
		}
	}
}
