package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Notice_page;
import com.service.Notice_list_service;

public class Main_board_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_board.jsp";
	private Notice_list_service nls = new Notice_list_service();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Main_board_handler action");
		
		String pageVal = request.getParameter("page_no");
		int pageNo = 1;
		if(pageVal != null) {
			pageNo = Integer.parseInt(pageVal);
		}
		try {
			Notice_page np = nls.getPage(pageNo);
			request.setAttribute("notice_page", np);
			return view;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
