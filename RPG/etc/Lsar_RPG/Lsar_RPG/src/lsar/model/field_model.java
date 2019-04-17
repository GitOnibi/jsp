package lsar.model;

public class field_model {
	private int field_num;
	private String field_name;
	private int field_level;
	private String field_national;
	
	
	public field_model(int field_num, String field_name, int field_level, String field_national) {
		super();
		this.field_num = field_num;
		this.field_name = field_name;
		this.field_level = field_level;
		this.field_national = field_national;
	}
	
	public int getField_num() {
		return field_num;
	}
	public void setField_num(int field_num) {
		this.field_num = field_num;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public int getField_level() {
		return field_level;
	}
	public void setField_level(int field_level) {
		this.field_level = field_level;
	}
	public String getField_national() {
		return field_national;
	}
	public void setField_national(String field_national) {
		this.field_national = field_national;
	}
}
