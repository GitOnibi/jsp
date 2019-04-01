package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Notice_service;
import com.service.Write_param;

public class Notice_handler implements Main_handler {
	private static final String view = "/WEB-INF/view/main_board.jsp";
	private Notice_service ns = new Notice_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Notice_handler action");
		
		Map<String, Boolean> error = new HashMap<>();
		request.setAttribute("error", error);
		
		String user_id = (String)request.getSession().getAttribute("user_id");
		Write_param wp = new Write_param(user_id, request.getParameter("title"), request.getParameter("cont"));
		wp.validate(error);
		if(error.isEmpty()) {
			return view;
			
		}
		int num = ns.write(wp);
		request.setAttribute("num", num);
		return view;
	}
}
