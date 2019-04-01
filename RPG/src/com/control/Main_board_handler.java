package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Notice;
import com.dao.Notice_DAO;

public class Main_board_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_board.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Main_board_handler action");
		
		Notice_DAO ndao = new Notice_DAO();
		List<Notice> content_list = ndao.getTitleList();
		request.setAttribute("content_list", content_list);
		return view;
	}
}
