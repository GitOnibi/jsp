package lsar.service;

import java.util.Iterator;
import java.util.List;

import lsar.dao.field_DAO;
import lsar.model.field_model;
import lsar.model.field_national;

public class field_service {
	private	field_DAO f_dao = new field_DAO();
	
	public List<field_national> view_field(){
		System.out.println("field_service");
		List<field_national> data = national_();
		Iterator<field_national> fnt = data.iterator();
		while(fnt.hasNext()) {
			f_dao.select_all(fnt.next());
		}
		return data;
	}
	private List<field_national> national_() {
		return f_dao.select_national();
	}
}
