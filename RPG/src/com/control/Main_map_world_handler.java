package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main_map_world_handler implements Main_handler{
	private String view = "/WEB-INF/view/main_map_world.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		return view;
	}
}
