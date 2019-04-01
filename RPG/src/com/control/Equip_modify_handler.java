package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Equip;
import com.bean.Inven;
import com.bean.Character;
import com.dao.Character_DAO;
import com.dao.Equip_DAO;
import com.dao.Inven_DAO;
import com.dev.Item_DAO;
import com.dev.Item_bean;

public class Equip_modify_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Equip_modify_handler action");
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		int		weapon_code	= Integer.parseInt(request.getParameter("weapon_code")	);
		int		amor_code	= Integer.parseInt(request.getParameter("amor_code")	);
		int		gloves_code	= Integer.parseInt(request.getParameter("gloves_code")	);
		int		boots_code	= Integer.parseInt(request.getParameter("boots_code")	);
		int		sub1_code	= Integer.parseInt(request.getParameter("sub1_code")	);
		int		sub2_code	= Integer.parseInt(request.getParameter("sub2_code")	);
		int		sub3_code	= Integer.parseInt(request.getParameter("sub3_code")	);
		int		sk1_code	= Integer.parseInt(request.getParameter("sk1_code")		);
		int		sk2_code	= Integer.parseInt(request.getParameter("sk2_code")		);
		
		try {	
			// 장비변경실행
			Equip_DAO edao = new Equip_DAO();
			Equip equip = new Equip(user_id, char_name,weapon_code, amor_code, gloves_code, boots_code, sub1_code, sub2_code, sub3_code, sk1_code, sk2_code);
			edao.updateEquipList(equip);
			
			// 아이템정보 불러옴
			
			// 케릭터정보 업데이트
			Character_DAO cdao = new Character_DAO();
			Character ch1 = cdao.getChar(user_id, char_name);
			Character ch2 = new Character(
					ch1.getUser_id(),
					ch1.getChar_name(),
					ch1.getChar_lv(),
					ch1.getChar_str(),
					ch1.getChar_dex(),
					ch1.getChar_hp(),
					ch1.getChar_atk(),
					ch1.getChar_def(),
					ch1.getChar_agi(),
					ch1.getChar_crt(),
					ch1.getChar_exp()
			);
			cdao.updateChar(ch2);
			
			response.sendRedirect("main_inventory.do");
			return null;
		} catch(RuntimeException e) {
			return view;
		}
	}
}
