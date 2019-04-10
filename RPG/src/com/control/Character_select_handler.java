package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.bean.User;
import com.dao.Character_DAO;

public class Character_select_handler implements Main_handler {
	private String view = "/WEB-INF/view/character_select.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		User user = (User)request.getSession().getAttribute("user");
		String user_id = user.getUser_id();
		Character_DAO cdao = new Character_DAO();
		List<Character> list = cdao.getCharList(user_id);
		request.setAttribute("list", list);
		return view;
	}
}
