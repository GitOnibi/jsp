package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Goto_join_handler implements Main_handler {
	private String view = "/WEB-INF/view/member_join.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		return view;
	}
}
