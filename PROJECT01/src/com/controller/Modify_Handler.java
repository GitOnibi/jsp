package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.Modify_service;

public class Modify_Handler implements Main_Handler {
	private String view = "/WEB-INF/show/modify.jsp";
	private Modify_service ms = new Modify_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("- Modify_Handler action");
		if(request.getMethod().equalsIgnoreCase("POST")) {
			User data = (User)request.getSession().getAttribute("user");
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");
			Map<String, Boolean> err = new HashMap<>();
			request.setAttribute("err", err);
			
			if(name == null || name.isEmpty()) err.put("name", Boolean.TRUE);
			
			if(birth == null || birth.isEmpty()) err.put("birth", Boolean.TRUE);
			
			if(!err.isEmpty()) return view;
			
			try {
				ms.changeInfo(data.getId(), name, birth);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return null;
			} catch(RuntimeException e) {
				System.out.println(e);
				return view;
			}
		} else {
			return view;
		}
	}
}