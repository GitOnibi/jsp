package com.dev;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Member;
import com.dao.Member_DAO;

public class Goto_dev_user_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_user.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("- Goto_dev_user_handler acrion");
		Member_DAO mdao = new Member_DAO();
		List<Member> list = mdao.getMemberList();
		request.setAttribute("list", list);
		return view;
	}
}
