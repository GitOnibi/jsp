package info;

import java.util.Date;

public class notice {
	private int number;
	private String writer;
	private String title;
	private Date regdate;
	private Date modifiedDate;
	private int read_cnt;
	
	public notice(int number, String writer, String title, Date regdate, Date modifiedDate, int read_cnt) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.modifiedDate = modifiedDate;
		this.read_cnt = read_cnt;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
}
