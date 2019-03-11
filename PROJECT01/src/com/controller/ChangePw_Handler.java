package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.ChgPw_service;

public class ChangePw_Handler implements Main_Handler {
	private String view = "/WEB-INF/show/chgpw.jsp";
	private ChgPw_service cs = new ChgPw_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- ChangePw_Handler action");
		if(request.getMethod().equalsIgnoreCase("POST")) {
			User data = (User)request.getSession().getAttribute("user");
			
			Map<String, Boolean> err = new HashMap<>();
			request.setAttribute("err", err);
			
			String pw = request.getParameter("pw");
			String npw = request.getParameter("npw");
			if(pw == null || pw.isEmpty()) {
				System.out.println("pw true");
				err.put("pw", Boolean.TRUE);
			}
			
			if(npw == null || npw.isEmpty()) {
				System.out.println("npw true");
				err.put("npw", Boolean.TRUE);
			}
			
			if(pw == npw) {
				err.put("eq", Boolean.TRUE);
			}
			
			if(!err.isEmpty()) {
				return view;
			}
			try {
				cs.changePassword(data.getId(), pw, npw);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return null;
			} catch(RuntimeException e) {
				System.out.println(e);
				if(e.getMessage().equals("notmatch")) {
					err.put("notmatch", Boolean.TRUE);
				}
				return view;
			}
		} else {
			return view;
		}
	}
}
