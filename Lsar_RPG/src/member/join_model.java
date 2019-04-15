package member;

import java.util.Date;

public class join_model {
	private String id;
	private String pw;
	private String email;
	private Date j_date;
	private Date last_date;
	private String location;
	private String key_num;// 
	public join_model(String id, String pw, String email,Date jd) {
		this.id=id;
		this.pw=pw;
		this.email=email;
		this.j_date=jd;
		this.last_date=jd;
	}
	public boolean MatchPW(String pw) {
		return this.pw.equals(pw);
	}
	public void chg_Password(String npwd) {
		this.pw=npwd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
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
	public String getKey_num() {
		return key_num;
	}
	public void setKey_num(String key_num) {
		this.key_num = key_num;
	}
	
	
}
