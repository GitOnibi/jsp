package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Join_param;
import com.service.Join_service;

public class Idcheck_Handler implements Main_Handler {
	private String view = "/WEB-INF/show/join_write.jsp";
	private Join_service js = new Join_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Idcheck_Handler action");
		Join_param jp = new Join_param();
		jp.setId(request.getParameter("id"));
		
		Map<String, Boolean> err = new HashMap<String, Boolean>();
		request.setAttribute("err", err);
		try {
			js.idCheck(jp);
			err.put("dup", Boolean.FALSE);
		} catch(Exception e) {
			err.put("dup", Boolean.TRUE);
		}
		return view;
	}
}
