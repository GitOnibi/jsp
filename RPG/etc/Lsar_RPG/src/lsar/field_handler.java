package lsar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsar.model.field_model;
import lsar.model.field_national;
import lsar.service.field_service;
import main_cnt.main_hnd;

public class field_handler implements main_hnd{
	private String view = "/lsar.jsp";
	private field_service fs = new field_service();
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("field");
		
		List<field_national> field_ = fs.view_field();
		req.setAttribute("field", field_);
		req.setAttribute("part", "field");
		req.setAttribute("page", "/field_main.jsp");
		return view;
	}
}