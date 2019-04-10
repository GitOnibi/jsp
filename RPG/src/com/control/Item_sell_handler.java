package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Character_DAO;
import com.dao.Inven_DAO;
import com.bean.Character;

public class Item_sell_handler implements Main_handler {
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Item_sell_handler action");
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		int item_code = Integer.parseInt(request.getParameter("item_code"));
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		
		try {
			Inven_DAO idao = new Inven_DAO();
			idao.sellItem(user_id, char_name, item_code);
			
			Character_DAO cdao = new Character_DAO();
			Character ch1 = cdao.getChar(user_id, char_name);
			
			Character ch2 = new Character(
				user_id, char_name,
				ch1.getChar_lv(),
				ch1.getChar_str(),
				ch1.getChar_dex(),
				ch1.getChar_hp(),
				ch1.getChar_atk(),
				ch1.getChar_def(),
				ch1.getChar_agi(),
				ch1.getChar_crt(),
				ch1.getChar_exp(),
				ch1.getChar_money() + item_price
			);
			cdao.updateChar(ch2);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return "main_inventory.do";
	}
}
