package com.service;

import java.util.Map;

public class Join_param {
	private String id;
	private String name;
	private String password;
	private String cnf_pw;
	private String birth;
	
	public boolean  password_cnf() {
		return password != null && password.equals(cnf_pw);
	}
	
	public void value_empty(Map<String, Boolean> empty) {
		check(empty, id, "id");
		check(empty, name, "name");
		check(empty, password, "password");
		check(empty, cnf_pw, "cnf_pw");
		if(empty.containsKey("cnf_pw")) {
			if(!password_cnf()) {
				empty.put("Not Match", Boolean.TRUE);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCnf_pw() {
		return cnf_pw;
	}
	public void setCnf_pw(String cnf_pw) {
		this.cnf_pw = cnf_pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

}
