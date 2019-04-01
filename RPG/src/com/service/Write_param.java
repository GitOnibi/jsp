package com.service;

import java.util.Map;

public class Write_param {
	private String user_id;
	private String title;
	private String content;
	public Write_param(String user_id, String title, String content) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
	}
	public void validate(Map<String, Boolean> error) {
		if(title == null || title.trim().isEmpty()) {
			error.put("title", Boolean.TRUE);
		}
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
