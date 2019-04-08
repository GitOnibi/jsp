package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Notice_content;
import com.dao.Notice_cont_DAO;

public class Goto_modify_handler implements Main_handler {
	private String view = "/WEB-INF/view/notice_modify.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Notice_cont_DAO ncdao = new Notice_cont_DAO();
		
		try {
			List<Notice_content> cont = ncdao.getCont(no);
			request.setAttribute("cont", cont);
			return view;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
