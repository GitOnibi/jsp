package com.service;

public class Join_param {
	private String id;
	private String name;
	private String pw;
	private String pw_cnf;
	private String birth;
	
	public boolean  password_cnf() {
		return pw != null && pw.equals(pw_cnf);
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
