package com.dev;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dev_login_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_login.jsp";
	Dev_DAO ddao = new Dev_DAO();
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Dev_login_handler action");
		if(request.getMethod().equalsIgnoreCase("GET")) return view;
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String dev_id = request.getParameter("dev_id");
			String dev_pw = request.getParameter("dev_pw");
			Dev dev_user = null;
			try {
				dev_user = ddao.getDev(dev_id, dev_pw);
				request.getSession().setAttribute("dev_user", dev_user);
				response.sendRedirect("goto_dev_main.dev");
				return null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return view;
	}
}
