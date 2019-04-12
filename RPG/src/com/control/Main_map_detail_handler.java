package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.dao.Character_DAO;
import com.dao.Equip_DAO;
import com.dev.Item_DAO;
import com.dev.Item_bean;
import com.dev.Mob_DAO;
import com.dev.Mob_bean;

public class Main_map_detail_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_map_detail.jsp";	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("- Main_map_detail_handler action");
		
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
		
		// 소지하고 있는 아이템 리스트
		Item_DAO idao = new Item_DAO();
		List<Item_bean> inven_list = idao.getInvenList(user_id, char_name);
		request.setAttribute("inven_list", inven_list);
		
		// 장착 가능한 무기 리스트
		Equip_DAO edao1 = new Equip_DAO();
		List<Item_bean> weapon_list = edao1.getEquipableList(user_id, char_name, 1);
		request.setAttribute("weapon_list", weapon_list);
		
		// 장착 가능한 갑옷 리스트
		Equip_DAO edao2 = new Equip_DAO();
		List<Item_bean> amor_list = edao2.getEquipableList(user_id, char_name, 2);
		request.setAttribute("amor_list", amor_list);
		
		// 장착 가능한 장갑 리스트
		Equip_DAO edao3 = new Equip_DAO();
		List<Item_bean> gloves_list = edao3.getEquipableList(user_id, char_name, 3);
		request.setAttribute("gloves_list", gloves_list);
		
		// 장착 가능한 신발 리스트
		Equip_DAO edao4 = new Equip_DAO();
		List<Item_bean> boots_list = edao4.getEquipableList(user_id, char_name, 4);
		request.setAttribute("boots_list", boots_list);
		
		// 장착 가능한 보조장비 리스트
		Equip_DAO edao5 = new Equip_DAO();
		List<Item_bean> sub_list = edao5.getEquipableList(user_id, char_name, 5);
		request.setAttribute("sub_list", sub_list);
		
		// 몹정보
		Mob_DAO mdao = new Mob_DAO();
		List<Mob_bean> mob_list = mdao.getMobList();
		request.setAttribute("mob_list", mob_list);
		
		return view;
	}
}
