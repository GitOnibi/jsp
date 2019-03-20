package com.dev;

public class Dev {
	private String dev_id;
	private String dev_pw;
	private String dev_email;
	
	public Dev(String dev_id, String dev_email) {
		this.dev_id		= dev_id;
		this.dev_email	= dev_email;
	}
	
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String dev_id) {
		this.dev_id = dev_id;
	}
	public String getDev_pw() {
		return dev_pw;
	}
	public void setDev_pw(String dev_pw) {
		this.dev_pw = dev_pw;
	}
	public String getDev_email() {
		return dev_email;
	}
	public void setDev_email(String dev_email) {
		this.dev_email = dev_email;
	}
}
