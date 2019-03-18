package com.service;

import java.util.Map;

public class Join_param {
	private String id;
	private String name;
	private String pw;
	private String pw_cnf;
	private String birth;
	
	public boolean  pw_cnf() {
		return pw != null && pw.equals(pw_cnf);
	}
	
	public void value_empty(Map<String, Boolean> empty) {
		System.out.println("- Join_param value_empty");
		check(empty, id, "id");
		check(empty, name, "name");
		check(empty, pw, "pw");
		check(empty, pw_cnf, "pw_cnf");
		if(empty.containsKey("pw_cnf")) {
			if(!pw_cnf()) {
				empty.put("NotMatch", Boolean.TRUE);
			}
		}
		check(empty, birth, "birth");
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw_cnf() {
		return pw_cnf;
	}
	public void setPw_cnf(String pw_cnf) {
		this.pw_cnf = pw_cnf;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

}