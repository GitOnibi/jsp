package member;

import java.util.Date;
import java.util.Map;

public class join_param {
	private String id;
	private String pw;
	private String Cmp_pw;
	private String email;
	private Date j_date;
	private Date last_date;
	private String location;
	
	public boolean password_cmp() {
		return pw !=null &&pw.equals(Cmp_pw);
	}
	public void value_empty(Map<String,Boolean> empty) {
		check(empty,id,"id");
		check(empty,email,"email");
		check(empty,pw,"pw");
		check(empty,Cmp_pw,"Cmp_pw");
		if(!empty.containsKey("Cmp_pw")) {
			if(!password_cmp())
				empty.put("NotMatch", Boolean.TRUE);
		}
	}
	private void check(Map<String,Boolean> emp,String value,String name) {
		if(value==null || value.isEmpty()) 
			emp.put(name, Boolean.TRUE);
	}
	public String getCmp_pw() {
		return Cmp_pw;
	}
	public void setCmp_pw(String Cmp_pw) {
		this.Cmp_pw=Cmp_pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJ_date() {
		return j_date;
	}
	public void setJ_date(Date j_date) {
		this.j_date = j_date;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
