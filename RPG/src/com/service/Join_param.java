package com.service;

import java.util.Map;

public class Join_param {
	private String user_id;
	private String user_pw;
	private String user_pw_cnf;
	private String user_email;
	
	public boolean  pw_cnf() {
		return user_pw != null && user_pw.equals(user_pw_cnf);
	}
	
	public void value_empty(Map<String, Boolean> empty) {
		System.out.println("- Join_param value_empty");
		check(empty, user_id, "user_id");
		check(empty, user_pw, "user_pw");
		check(empty, user_pw_cnf, "user_pw_cnf");
		if(empty.containsKey("user_pw_cnf")) {
			if(!pw_cnf()) {
				empty.put("NotMatch", Boolean.TRUE);
			}
		}
		check(empty, user_email, "user_email");
	}
	
	private void check(Map<String, Boolean> emp, String value, String name) {
		if(value == null || value.isEmpty()) {
			emp.put(name, Boolean.TRUE);
		}
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw_cnf() {
		return user_pw_cnf;
	}

	public void setUser_pw_cnf(String user_pw_cnf) {
		this.user_pw_cnf = user_pw_cnf;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

}