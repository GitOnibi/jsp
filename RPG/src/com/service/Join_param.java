package com.service;

public class Join_param {
	private String id;
	private String name;
	private String pw;
	private String cnf_pw;
	private String birth;
	
	public boolean  password_cnf() {
		return pw != null && pw.equals(cnf_pw);
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
