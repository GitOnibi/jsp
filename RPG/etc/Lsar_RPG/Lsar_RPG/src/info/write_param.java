package info;

import java.util.Map;

public class write_param {
	
	private String writer;
	private String title;
	private String content;
	
	public write_param(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	public void validate(Map<String,Boolean> error) {
		if(title==null || title.trim().isEmpty()) {
			error.put("title", Boolean.TRUE);
		}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
