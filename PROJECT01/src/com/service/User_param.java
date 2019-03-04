package com.service;

import java.util.Map;

public class User_param {
	private String id;
	private String name;
	
	public void value_empty(Map<String, Boolean> empty) {
		check(empty, id, "id");
		check(empty, name, "name");
	}
	
	private void check(Map<String, Boolean> emp, String value, String name) {
		if(value == null || value.isEmpty()) {
			emp.put(name, Boolean.TRUE);
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
