package com.dev;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Goto_dev_mob_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_mob.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Goto_dev_mob_handler action");
		Mob_DAO mdao = new Mob_DAO();
		List<Mob_bean> list = mdao.getMobList();
		request.setAttribute("list", list);
		return view;
	}
}
