package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Equip;
import com.dao.Equip_DAO;

public class Equip_modify_handler implements Main_handler {
	private String view = "/WEB-INF/view/main_inventory.jsp";
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("- Equip_modify_handler action");
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		String[] mcodes		= request.getParameterValues("modify_code");
		String reqStr		= request.getParameter("reqStr");

		try {	
			// 장비변경실행
			Equip_DAO edao	= new Equip_DAO();
			Equip equip		= null;
			for(int i = 0; i < mcodes.length; i++) {
				equip = new Equip(i + 1, Integer.parseInt(mcodes[i]), char_name, user_id);
				edao.updateEquipList(equip);
			}
			return reqStr + ".do";
		} catch(RuntimeException e) {
			return view;
		}
	}
}
