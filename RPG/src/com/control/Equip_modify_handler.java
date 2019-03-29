package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Equip;
import com.bean.Inven;
import com.dao.Equip_DAO;
import com.dao.Inven_DAO;
import com.dev.Item_DAO;
import com.dev.Item_bean;

public class Equip_modify_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Equip_modify_handler action");
		
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		Item_DAO idao = new Item_DAO();
		int		weapon_code	= Integer.parseInt(request.getParameter("weapon_code")	);
		int		amor_code	= Integer.parseInt(request.getParameter("amor_code")	);
		int		gloves_code	= Integer.parseInt(request.getParameter("gloves_code")	);
		int		boots_code	= Integer.parseInt(request.getParameter("boots_code")	);
		int		sub1_code	= Integer.parseInt(request.getParameter("sub1_code")	);
		int		sub2_code	= Integer.parseInt(request.getParameter("sub2_code")	);
		int		sub3_code	= Integer.parseInt(request.getParameter("sub3_code")	);
		int		sk1_code	= Integer.parseInt(request.getParameter("sk1_code")		);
		int		sk2_code	= Integer.parseInt(request.getParameter("sk2_code")		);
		String	weapon_name	= (weapon_code	== 0)	? "0" : idao.getItemName(weapon_code	); 
		String	amor_name	= (amor_code	== 0)	? "0" : idao.getItemName(amor_code		); 
		String	gloves_name	= (gloves_code	== 0)	? "0" : idao.getItemName(gloves_code	); 
		String	boots_name	= (boots_code	== 0)	? "0" : idao.getItemName(boots_code	); 
		String	sub1_name	= (sub1_code	== 0)	? "0" : idao.getItemName(sub1_code		); 
		String	sub2_name	= (sub2_code	== 0)	? "0" : idao.getItemName(sub2_code		); 
		String	sub3_name	= (sub3_code	== 0)	? "0" : idao.getItemName(sub3_code		); 
		String	sk1_name	= (sk1_code		== 0)	? "0" : idao.getItemName(sk1_code		); 
		String	sk2_name	= (sk2_code		== 0)	? "0" : idao.getItemName(sk2_code		); 
		
		try {	
			// 장비변경실행
			Equip_DAO edao = new Equip_DAO();
			Equip equip = new Equip(char_name, weapon_name, weapon_code, amor_name, amor_code, gloves_name, gloves_code, boots_name, boots_code, sub1_name, sub1_code, sub2_name, sub2_code, sub3_name, sub3_code, sk1_name, sk1_code, sk2_name, sk2_code);
			edao.updateEquipList(equip);
			
			// 아이템 능력치 가져오기
			Item_DAO idao2 = new Item_DAO();
			List<Item_bean> list = new ArrayList<>();
			list.add(idao2.getItemStatus(weapon_code));
			list.add(idao2.getItemStatus(amor_code));
			list.add(idao2.getItemStatus(gloves_code));
			list.add(idao2.getItemStatus(boots_code));
			list.add(idao2.getItemStatus(sub1_code));
			list.add(idao2.getItemStatus(sub2_code));
			list.add(idao2.getItemStatus(sub3_code));
			list.add(idao2.getItemStatus(sk1_code));
			list.add(idao2.getItemStatus(sk2_code));
			
			int sum_atk = 0;
			int sum_def = 0;
			System.out.println("---------123123123-----------");
			Iterator<Item_bean> it01 = list.iterator();
			while(it01.hasNext()) {
				System.out.println("--------------------");
				sum_atk += it01.next().getItem_atk();
				sum_def += it01.next().getItem_def();
				System.out.println(sum_atk);
				System.out.println(sum_def);
			}
			

			/*
			// 케릭터 정보 수정
			Character ch = new Character(
					user_id,
					char_name,
					char_lv,
					char_str,
					char_dex,
					char_hp,
					char_atk,
					char_def,
					char_agi,
					char_crt,
					char_exp
			);
			*/
			
			//response.sendRedirect("main_inventory.do");
			return view;
		} catch(RuntimeException e) {
			return view;
		}
	}
}
