package com.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Item_insert_handler implements Dev_handler {
	private String view = "/WEB-INF/dev/dev_item.jsp";
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) { return view; }
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			int		item_code	= Integer.parseInt(request.getParameter("item_code"));
			String	item_name	= request.getParameter("item_name");
			int		item_atk	= Integer.parseInt(request.getParameter("item_atk"));
			int		item_def	= Integer.parseInt(request.getParameter("item_def"));
			int		item_opt1	= Integer.parseInt(request.getParameter("item_opt1"));
			int		item_opt2	= Integer.parseInt(request.getParameter("item_opt2"));
			int		item_opt3	= Integer.parseInt(request.getParameter("item_opt3"));
			int		item_opt4	= Integer.parseInt(request.getParameter("item_opt4"));
			int		item_opt5	= Integer.parseInt(request.getParameter("item_opt5"));
			String	item_sub	= request.getParameter("item_sub");
			int		item_prop	= Integer.parseInt(request.getParameter("item_prop"));
			int		item_price	= Integer.parseInt(request.getParameter("item_price"));
			
			Item_DAO idao = new Item_DAO();
			
			try {
				Item_bean ib = new Item_bean(item_code, item_name, item_atk, item_def, item_opt1, item_opt2, item_opt3, item_opt4, item_opt5, item_sub, item_prop, item_price);
				idao.setItem(ib);
				String msg = "정상적으로 등록되었습니다";
				request.setAttribute("msg", msg);
				RequestDispatcher dsp = request.getRequestDispatcher("goto_dev_item.dev");
				dsp.forward(request, response);
				return null;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return view;
	}
}
