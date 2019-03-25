package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.Character_DAO;

public class Character_delete_handler implements Main_handler {
	private String view = "/WEB-INF/view/character_select.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Character_delete_handler action");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String user_id		= request.getParameter("user_id");
			String char_name	= request.getParameter("char_name");
			try {
				Character_DAO cdao = new Character_DAO();
				cdao.deleteChar(user_id, char_name);
				String msg = "케릭터가 삭제되었습니다.";
				request.setAttribute("msg", msg);
				response.sendRedirect("character_select.do");
				return null;
			} catch(RuntimeException e) {
				return view;
			}
		}
		return view;
	}
}
