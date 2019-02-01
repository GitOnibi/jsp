package com.jdbc;

import javax.servlet.http.HttpServletRequest;

public class Join {
	private String name;
	private String id;
	private String pw;
	private int num;
	
	public void insert(HttpServletRequest request) {
		this.name	= request.getParameter("name");
		this.id		= request.getParameter("id");
		this.pw		= request.getParameter("pw");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
