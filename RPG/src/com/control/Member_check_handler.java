package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Member_check_handler implements Main_handler {
	private String view = "/WEB-INF/view/member_join.jsp";
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return view;
	}
}
