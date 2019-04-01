package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.bean.Equip;
import com.bean.Inven;
import com.dao.Character_DAO;
import com.dao.Equip_DAO;
import com.dao.Inven_DAO;

public class Main_inventroy_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Main_inventroy_handler action");
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		try {
			// 케릭터 정보
			List<Character> char_info = new ArrayList<>();
			Character_DAO cdao = new Character_DAO();
			char_info.add(cdao.getChar(user_id, char_name));
			request.setAttribute("char_info", char_info);
			
			// 소지하고 있는 아이템 리스트
			Inven_DAO idao = new Inven_DAO();
			List<Inven> inven_list = idao.getInvenList(char_name);
			request.setAttribute("inven_list", inven_list);
			
			// 착용중인 장비 리스트
			Equip_DAO edao0 = new Equip_DAO();
			List<Equip> equip_list = edao0.getEquipList(user_id, char_name);
			request.setAttribute("equip_list", equip_list);
			
			// 장착 가능한 무기 리스트
			Equip_DAO edao1 = new Equip_DAO();
			List<Inven> weapon_list = edao1.getEquipableList(char_name, 1);
			request.setAttribute("weapon_list", weapon_list);
			
			// 장착 가능한 갑옷 리스트
			Equip_DAO edao2 = new Equip_DAO();
			List<Inven> amor_list = edao2.getEquipableList(char_name, 2);
			request.setAttribute("amor_list", amor_list);
			
			// 장착 가능한 장갑 리스트
			Equip_DAO edao3 = new Equip_DAO();
			List<Inven> gloves_list = edao3.getEquipableList(char_name, 3);
			request.setAttribute("gloves_list", gloves_list);
			
			// 장착 가능한 신발 리스트
			Equip_DAO edao4 = new Equip_DAO();
			List<Inven> boots_list = edao4.getEquipableList(char_name, 4);
			request.setAttribute("boots_list", boots_list);
			
			// 장착 가능한 보조장비 리스트
			Equip_DAO edao5 = new Equip_DAO();
			List<Inven> sub_list = edao5.getEquipableList(char_name, 5);
			request.setAttribute("sub_list", sub_list);
			
			return view;
		} catch(RuntimeException e) {
			return view;
		}
	}
}
