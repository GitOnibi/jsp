package com.bean;

public class Equip {
	private int		idx;
	private int		item_code;
	private String	char_name;
	private String	user_id;
	public Equip(int idx, int item_code, String char_name, String user_id) {
		super();
		this.idx = idx;
		this.item_code = item_code;
		this.char_name = char_name;
		this.user_id = user_id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getChar_name() {
		return char_name;
	}
	public void setChar_name(String char_name) {
		this.char_name = char_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
