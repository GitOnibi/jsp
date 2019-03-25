package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Inven;
import com.dao.Inven_DAO;

public class Main_inventroy_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Main_inventroy_handler action");
		
		String char_name = (String)request.getSession().getAttribute("char_name");
		System.out.println(char_name);
		try {
			Inven_DAO idao = new Inven_DAO();
			List<Inven> inven_list = idao.getInvenList(char_name);
			request.setAttribute("inven_list", inven_list);
			return view;
		} catch(RuntimeException e) {
			return view;
		}
	}
}
