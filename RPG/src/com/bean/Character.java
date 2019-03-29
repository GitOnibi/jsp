package com.bean;

public class Character {
	private String user_id;
	private String char_name;
	private int char_lv;
	private int char_str;
	private int char_dex;
	private int char_hp;
	private int char_atk;
	private int char_def;
	private int char_agi;
	private int char_crt;
	private int char_exp;
	
	public Character() {}
	
	public Character(String user_id, String char_name, int char_lv) {
		this.user_id = user_id;
		this.char_name = char_name;
		this.char_lv = char_lv;
	}
	
	public Character(String user_id, String char_name, int char_lv, int char_str, int char_dex, int char_hp,
			int char_atk, int char_def, int char_agi, int char_crt, int char_exp) {
		this.user_id = user_id;
		this.char_name = char_name;
		this.char_lv = char_lv;
		this.char_str = char_str;
		this.char_dex = char_dex;
		this.char_hp = char_hp;
		this.char_atk = char_atk;
		this.char_def = char_def;
		this.char_agi = char_agi;
		this.char_crt = char_crt;
		this.char_exp = char_exp;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getChar_name() {
		return char_name;
	}

	public void setChar_name(String char_name) {
		this.char_name = char_name;
	}

	public int getChar_lv() {
		return char_lv;
	}

	public void setChar_lv(int char_lv) {
		this.char_lv = char_lv;
	}

	public int getChar_str() {
		return char_str;
	}

	public void setChar_str(int char_str) {
		this.char_str = char_str;
	}

	public int getChar_dex() {
		return char_dex;
	}

	public void setChar_dex(int char_dex) {
		this.char_dex = char_dex;
	}

	public int getChar_hp() {
		return char_hp;
	}

	public void setChar_hp(int char_hp) {
		this.char_hp = char_hp;
	}

	public int getChar_atk() {
		return char_atk;
	}

	public void setChar_atk(int char_atk) {
		this.char_atk = char_atk;
	}

	public int getChar_def() {
		return char_def;
	}

	public void setChar_def(int char_def) {
		this.char_def = char_def;
	}

	public int getChar_agi() {
		return char_agi;
	}

	public void setChar_agi(int char_agi) {
		this.char_agi = char_agi;
	}

	public int getChar_crt() {
		return char_crt;
	}

	public void setChar_crt(int char_crt) {
		this.char_crt = char_crt;
	}

	public int getChar_exp() {
		return char_exp;
	}

	public void setChar_exp(int char_exp) {
		this.char_exp = char_exp;
	}
	
}
