package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Intro_handler implements Main_handler {
	private String view = "/WEB-INF/view/intro.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String char_name = request.getParameter("char_name");
		request.getSession().setAttribute("char_name", char_name);
		return view;
	}
}
