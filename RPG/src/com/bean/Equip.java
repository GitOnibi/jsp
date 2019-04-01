package com.bean;

public class Equip {
	private String	user_id;
	private String	char_name;
	private int		weapon_code;
	private int		amor_code;
	private int		gloves_code;
	private int		boots_code;
	private int		sub1_code;
	private int		sub2_code;
	private int		sub3_code;
	private int		sk1_code;
	private int		sk2_code;
	public Equip(String user_id, String char_name, int weapon_code, int amor_code, int gloves_code, int boots_code,
			int sub1_code, int sub2_code, int sub3_code, int sk1_code, int sk2_code) {
		super();
		this.user_id = user_id;
		this.char_name = char_name;
		this.weapon_code = weapon_code;
		this.amor_code = amor_code;
		this.gloves_code = gloves_code;
		this.boots_code = boots_code;
		this.sub1_code = sub1_code;
		this.sub2_code = sub2_code;
		this.sub3_code = sub3_code;
		this.sk1_code = sk1_code;
		this.sk2_code = sk2_code;
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
	public int getWeapon_code() {
		return weapon_code;
	}
	public void setWeapon_code(int weapon_code) {
		this.weapon_code = weapon_code;
	}
	public int getAmor_code() {
		return amor_code;
	}
	public void setAmor_code(int amor_code) {
		this.amor_code = amor_code;
	}
	public int getGloves_code() {
		return gloves_code;
	}
	public void setGloves_code(int gloves_code) {
		this.gloves_code = gloves_code;
	}
	public int getBoots_code() {
		return boots_code;
	}
	public void setBoots_code(int boots_code) {
		this.boots_code = boots_code;
	}
	public int getSub1_code() {
		return sub1_code;
	}
	public void setSub1_code(int sub1_code) {
		this.sub1_code = sub1_code;
	}
	public int getSub2_code() {
		return sub2_code;
	}
	public void setSub2_code(int sub2_code) {
		this.sub2_code = sub2_code;
	}
	public int getSub3_code() {
		return sub3_code;
	}
	public void setSub3_code(int sub3_code) {
		this.sub3_code = sub3_code;
	}
	public int getSk1_code() {
		return sk1_code;
	}
	public void setSk1_code(int sk1_code) {
		this.sk1_code = sk1_code;
	}
	public int getSk2_code() {
		return sk2_code;
	}
	public void setSk2_code(int sk2_code) {
		this.sk2_code = sk2_code;
	}
	
}
