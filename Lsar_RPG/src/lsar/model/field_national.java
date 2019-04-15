package lsar.model;

import java.util.List;

public class field_national {
	public field_national(List<field_model> name, String national) {
		super();
		this.name = name;
		this.national = national;
	}
	private List<field_model> name;
	private String national;
	
	public List<field_model> getName() {
		return name;
	}
	public void setName(List<field_model> name) {
		this.name = name;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
}
