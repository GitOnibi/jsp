package com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.dao.Character_DAO;

public class Character_create_handler implements Main_handler {
	private String view = "/WEB-INF/view/character_select.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Character_create_handler action");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return view;
		}
		if(request.getMethod().equalsIgnoreCase("POST")) {
			String user_id		= request.getParameter("user_id");
			String char_name	= request.getParameter("char_name");
			int char_lv			= Integer.parseInt(request.getParameter("char_lv"));
			int char_str		= Integer.parseInt(request.getParameter("char_str"));
			int char_dex		= Integer.parseInt(request.getParameter("char_dex"));
			int char_hp			= Integer.parseInt(request.getParameter("char_hp"));
			int char_atk		= Integer.parseInt(request.getParameter("char_atk"));
			int char_def		= Integer.parseInt(request.getParameter("char_def"));
			int char_agi		= Integer.parseInt(request.getParameter("char_agi"));
			int char_crt		= Integer.parseInt(request.getParameter("char_crt"));
			int char_exp		= Integer.parseInt(request.getParameter("char_exp"));
			
			Character ch = new Character();
			ch.setUser_id(user_id);
			ch.setChar_name(char_name);
			ch.setChar_lv(char_lv);
			ch.setChar_str(char_str);
			ch.setChar_dex(char_dex);
			ch.setChar_hp(char_hp);
			ch.setChar_atk(char_atk);
			ch.setChar_def(char_def);
			ch.setChar_agi(char_agi);
			ch.setChar_crt(char_crt);
			ch.setChar_exp(char_exp);
			
			try {
				Character_DAO cdao = new Character_DAO();
				cdao.setChar(ch);
				String msg = "케릭터가 생성되었습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher dsp = request.getRequestDispatcher("character_select.do");
				dsp.forward(request, response);
				return null;
			} catch(RuntimeException e) {
				return view;
			}
		}
		return view;
	}
}
