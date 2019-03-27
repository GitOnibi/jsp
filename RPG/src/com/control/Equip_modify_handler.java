package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Equip_modify_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weapon = request.getParameter("weapon");
		String amor = request.getParameter("amor");
		String gloves = request.getParameter("gloves");
		String boots = request.getParameter("boots");
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		String sub3 = request.getParameter("sub3");
		String sk1 = request.getParameter("sk1");
		String sk2 = request.getParameter("sk2");
		
		
		return view;
	}
}
