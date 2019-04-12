package com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Character;
import com.dao.Character_DAO;
import com.dao.Inven_DAO;
import com.dev.Mob_DAO;
import com.dev.Mob_bean;

public class Character_update_handler implements Main_handler {
	private Character_DAO cdao = new Character_DAO();
	private Mob_DAO mdao = new Mob_DAO();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String user_id		= (String)request.getSession().getAttribute("user_id");
		String char_name	= (String)request.getSession().getAttribute("char_name");
		
		int hp		= Integer.parseInt(request.getParameter("hp"));
		int code	= Integer.parseInt(request.getParameter("code"));
		String log	= request.getParameter("log"); 
		
		Character ch1 = null;
		Mob_bean mb = mdao.getMob(code);
		ch1 = cdao.getChar(user_id, char_name);
		
		int score = ch1.getChar_exp() + mb.getMob_exp();
		int cnt = 1;
		while(score >= 100) {
			cnt++;
			score -= cnt * 100;
		}
		
		// 케릭터 정보 업데이트
		int lv		= cnt;
		int str		= 10 + lv * 2;
		int dex		= 10 + lv * 1;
		int atk		= str + dex / 10;
		int def		= dex / 2 + str / 10;
		int agi 	= str / 20 + dex / 10;
		int crt 	= str / 10 + dex / 10;
		int exp 	= ch1.getChar_exp() + mb.getMob_exp();
		int money	= ch1.getChar_money();
		
		Character ch2 = new Character(user_id, char_name, lv, str, dex, hp, atk, def, agi, crt, exp, money);
		cdao.updateChar(ch2);
		
		// 아이템 드롭
		Mob_DAO mdao = new Mob_DAO();
		List<Integer> drop_list = mdao.dropItem(mb.getMob_code());
		Inven_DAO idao = new Inven_DAO();
		for(int i = 0; i < drop_list.size(); i++) {
			idao.insertInven(user_id, char_name, drop_list.get(i));
		}
		
		String msg = null;
		if(ch1.getChar_lv() < ch2.getChar_lv()) {
			msg = "레벨업 하였습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("log", log);
		return "main_map_detail.do";
	}
}
