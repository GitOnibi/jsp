package com.model;

import java.util.Date;

public class Member {
	private String id;
	private String name;
	private String password;
	private Date date;
	private String birth;
	
	public Member(String id, String name, String password, Date date, String birth) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.date = date;
		this.birth = birth;
	}
	
	public boolean matchPW(String pw) {
		return password.equals(pw);
	}
	
	public void chg_password(String npwd) {
		this.password = npwd;
	}
	
	public void chg_info(String name, String birth) {
		this.name = name;
		this.birth = birth;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}