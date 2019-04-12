package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.dao.Character_DAO;

public class Restoration_handler implements Main_handler {
	private Character_DAO cdao = new Character_DAO();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Restoration_handler action");
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		try {
			Character ch1 = cdao.getChar(user_id, char_name);
			
			Character ch2 = new Character(
				user_id, char_name,
				ch1.getChar_lv(),
				ch1.getChar_str(),
				ch1.getChar_dex(),
				ch1.getChar_str() * 10,
				ch1.getChar_atk(),
				ch1.getChar_def(),
				ch1.getChar_agi(),
				ch1.getChar_crt(),
				ch1.getChar_exp(),
				ch1.getChar_money() - 50
			);
			cdao.updateChar(ch2);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "main_map_world.do";
	}
}
