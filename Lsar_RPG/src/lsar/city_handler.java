package lsar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main_cnt.main_hnd;

public class city_handler implements main_hnd{
	private String view = "/lsar.jsp";
	//private join_service js = new join_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("city");
		req.setAttribute("part", "national_city");
		req.setAttribute("page", "/national_main.jsp");
		return view;
	}
}