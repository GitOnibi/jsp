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
			String id		= request.getParameter("id");
			String pw		= request.getParameter("pw");
			String name		= request.getParameter("name");
			String cnf_pw	= request.getParameter("cnf_pw");
			String birth	= request.getParameter("birth");
			
			Map<String, Boolean> empty_ck = new HashMap<>();
			
			if(id == null || id.isEmpty()) {
				empty_ck.put("empty_id", Boolean.TRUE);
			}
			
			if(pw == null || pw.isEmpty()) {
				empty_ck.put("empty_pw", Boolean.TRUE);
			}
			
			if(name == null || name.isEmpty()) {
				empty_ck.put("empty_name", Boolean.TRUE);
			}
			
			if(cnf_pw == null || cnf_pw.isEmpty()) {
				empty_ck.put("empty_cnf_pw", Boolean.TRUE);
			}
			
			if(birth == null || birth.isEmpty()) {
				empty_ck.put("empty_birth", Boolean.TRUE);
			}
			
			if(empty_ck.isEmpty()) {
				return view;
			}
			
			request.setAttribute("empty_ck", empty_ck);
			
			Join_param jp = new Join_param();
			jp.setId(id);
			jp.setName(name);
			jp.setPw(pw);
			jp.setPw_cnf(cnf_pw);
			jp.setBirth(birth);
			
			try {
				js.join(jp);
				return "/WEB-INF/view/member_join_ok.jsp";
			} catch(RuntimeException e) {
				empty_ck.put("exception", Boolean.TRUE);
				return view;
			}
		}
		return view;
	}
}
