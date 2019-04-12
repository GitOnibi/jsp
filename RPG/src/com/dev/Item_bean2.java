package com.dev;

public class Item_bean2 {
	private int item_code;
	private String item_name;
	private int item_atk;
	private int item_def;
	private String item_sub;
	private int item_prop;
	private int item_price;
	private int item_count;
	public Item_bean2(int item_code, String item_name, int item_atk, int item_def, String item_sub, int item_prop,
			int item_price, int item_count) {
		super();
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_atk = item_atk;
		this.item_def = item_def;
		this.item_sub = item_sub;
		this.item_prop = item_prop;
		this.item_price = item_price;
		this.item_count = item_count;
	}
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_atk() {
		return item_atk;
	}
	public void setItem_atk(int item_atk) {
		this.item_atk = item_atk;
	}
	public int getItem_def() {
		return item_def;
	}
	public void setItem_def(int item_def) {
		this.item_def = item_def;
	}
	public String getItem_sub() {
		return item_sub;
	}
	public void setItem_sub(String item_sub) {
		this.item_sub = item_sub;
	}
	public int getItem_prop() {
		return item_prop;
	}
	public void setItem_prop(int item_prop) {
		this.item_prop = item_prop;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
}
