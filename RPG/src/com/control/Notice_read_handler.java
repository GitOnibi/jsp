package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Notice_cont_DAO;

public class Notice_read_handler implements Main_handler {
	private static final String view = "/WEB-INF/view/notice_read.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Notice_read_handler action");
		
		int no			= Integer.parseInt(request.getParameter("no"));
		String page_no	= request.getParameter("page_no");
		
		try {
			Notice_cont_DAO ncdao = new Notice_cont_DAO();
			request.setAttribute("cont", ncdao.getCont(no));
			return view;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
