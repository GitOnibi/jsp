package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Join_param;
import com.service.Join_service;

public class Join_Handler implements Main_Handler {
	private String view = "/WEB-INF/show/join_write.jsp";
	private Join_service js = new Join_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Join_param jp = new Join_param();
		jp.setId(request.getParameter("id"));
		jp.setPassword(request.getParameter("pw"));
		jp.setPw_cnf(request.getParameter("pw_cnf"));
		jp.setName(request.getParameter("name"));
		jp.setBirth(request.getParameter("birth"));
		
		Map<String, Boolean> err = new HashMap<String, Boolean>();
		request.setAttribute("err", err);
		jp.value_empty(err);
		if(!err.isEmpty()) {
			return view;
		}
		try {
			js.join(jp);
			return "/WEB-INF/show/join_ok.jsp";
		} catch(Exception e) {
			err.put("dup", Boolean.TRUE);
			return view;
		}
	}
}