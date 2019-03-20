package com.dev;

public class Item_bean {
	private int item_code;
	private String item_name;
	private int item_atk;
	private int item_def;
	private int item_opt1;
	private int item_opt2;
	private int item_opt3;
	private int item_opt4;
	private int item_opt5;
	private String item_sub;
	private int item_prop;
	private int item_price;
	
	public Item_bean(int item_code, String item_name, int item_atk, int item_def, int item_opt1, int item_opt2, int item_opt3, int item_opt4, int item_opt5, String item_sub, int item_prop, int item_price) {
		this.item_code	= item_code;
		this.item_name	= item_name;
		this.item_atk	= item_atk;
		this.item_def	= item_def;
		this.item_opt1	= item_opt1;
		this.item_opt2	= item_opt2;
		this.item_opt3	= item_opt3;
		this.item_opt4	= item_opt4;
		this.item_opt5	= item_opt5;
		this.item_sub	= item_sub;
		this.item_prop	= item_prop;
		this.item_price	= item_price;
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

	public int getItem_opt1() {
		return item_opt1;
	}

	public void setItem_opt1(int item_opt1) {
		this.item_opt1 = item_opt1;
	}

	public int getItem_opt2() {
		return item_opt2;
	}

	public void setItem_opt2(int item_opt2) {
		this.item_opt2 = item_opt2;
	}

	public int getItem_opt3() {
		return item_opt3;
	}

	public void setItem_opt3(int item_opt3) {
		this.item_opt3 = item_opt3;
	}

	public int getItem_opt4() {
		return item_opt4;
	}

	public void setItem_opt4(int item_opt4) {
		this.item_opt4 = item_opt4;
	}

	public int getItem_opt5() {
		return item_opt5;
	}

	public void setItem_opt5(int item_opt5) {
		this.item_opt5 = item_opt5;
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
}
