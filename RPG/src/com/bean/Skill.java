package com.bean;

public class Skill {
	private int sk_code;
	private String sk_name;
	private int sk_atk;
	private int sk_def;
	private String sk_sub;
	public Skill(int sk_code, String sk_name, int sk_atk, int sk_def, String sk_sub) {
		this.sk_code = sk_code;
		this.sk_name = sk_name;
		this.sk_atk = sk_atk;
		this.sk_def = sk_def;
		this.sk_sub = sk_sub;
	}
	public int getSk_code() {
		return sk_code;
	}
	public void setSk_code(int sk_code) {
		this.sk_code = sk_code;
	}
	public String getSk_name() {
		return sk_name;
	}
	public void setSk_name(String sk_name) {
		this.sk_name = sk_name;
	}
	public int getSk_atk() {
		return sk_atk;
	}
	public void setSk_atk(int sk_atk) {
		this.sk_atk = sk_atk;
	}
	public int getSk_def() {
		return sk_def;
	}
	public void setSk_def(int sk_def) {
		this.sk_def = sk_def;
	}
	public String getSk_sub() {
		return sk_sub;
	}
	public void setSk_sub(String sk_sub) {
		this.sk_sub = sk_sub;
	}
}
