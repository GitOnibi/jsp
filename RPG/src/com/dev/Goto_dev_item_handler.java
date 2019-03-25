package com.dev;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Goto_dev_item_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_item.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Goto_dev_item_handler action");
		Item_DAO idao = new Item_DAO();
		List<Item_bean> list = idao.getItemList();
		request.setAttribute("list", list);
		return view;
	}
}
