package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.dao.Character_DAO;
import com.dao.Equip_DAO;
import com.dev.Item_bean;

public class Main_map_detail_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_map_detail.jsp";	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		// 케릭터 정보
		List<Character> char_info = new ArrayList<>();
		Character_DAO cdao = new Character_DAO();
		char_info.add(cdao.getChar(user_id, char_name));
		request.setAttribute("char_info", char_info);
		
		// 착용중인 장비 리스트
		Equip_DAO edao0 = new Equip_DAO();
		List<Item_bean> equip_list = edao0.getEquipList(user_id, char_name);
		request.setAttribute("equip_list", equip_list);
		
		// 스텟
		int sum_atk = 0;
		int sum_def = 0;
		for(int i = 0; i < equip_list.size(); i++) {
			sum_atk += equip_list.get(i).getItem_atk();
			sum_def += equip_list.get(i).getItem_def();
		}
		List<Integer> stat_list = new ArrayList<Integer>();
		stat_list.add(sum_atk);
		stat_list.add(sum_def);
		request.setAttribute("stat_list", stat_list);
		
		return view;
	}
}
