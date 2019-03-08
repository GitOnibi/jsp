package com.bean;

import java.util.Date;

public class Member {
	private String id;
	private String name;
	private String pw;
	private Date date;
	private String birth;
	
	public Member(String id, String name, String pw, Date date, String birth) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.date = date;
		this.birth = birth;
	}
	
	public boolean matchPW(String pw) {
		return pw.equals(pw);
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