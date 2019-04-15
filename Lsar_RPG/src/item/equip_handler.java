package item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;

public class equip_handler implements main_hnd{
	private String view = "/lsar.jsp";
	//private join_service js = new join_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("equip");
		return view;
	}
}