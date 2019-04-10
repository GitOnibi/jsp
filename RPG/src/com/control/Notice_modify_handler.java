package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Notice_content;
import com.dao.Notice_cont_DAO;

public class Notice_modify_handler implements Main_handler {
	private static final String view = "/WEB-INF/view/main_board.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Notice_modify_handler action");
		
		int no = Integer.parseInt(request.getParameter("num"));
		String cont = request.getParameter("cont");
		
		Notice_cont_DAO ncdao = new Notice_cont_DAO();
		Notice_content nc = new Notice_content(no, cont);
		
		try {
			ncdao.modifyCont(nc);
			return "main_board.do";
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
