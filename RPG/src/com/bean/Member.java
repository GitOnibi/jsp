package com.bean;

import java.util.Date;

public class Member {
	private String user_id;
	private String user_pw;
	private Date date;
	private String user_email;
	
	public Member(String user_id, String user_pw, Date date, String user_email) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.date = date;
		this.user_email = user_email;
	}
	
	public boolean match_pw(String user_pw) {
		return this.user_pw.equals(user_pw);
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
}