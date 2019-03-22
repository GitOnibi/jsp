package com.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Item_delete_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_item.jsp";
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item_code = request.getParameter("item_code");
		
		Item_DAO idao = new Item_DAO();
		
		try {
			idao.deleteItem(item_code);
			String msg = "정상적으로 삭제되었습니다";
			request.setAttribute("msg", msg);
			RequestDispatcher dsp = request.getRequestDispatcher("goto_dev_item.dev");
			dsp.forward(request, response);
			return null;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return view;
	}
}
