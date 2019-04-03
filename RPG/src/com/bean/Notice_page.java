package com.bean;

import java.util.List;

public class Notice_page {
	private int total;
	private int curpage;		// 현제 페이지
	private List<Notice> cont;
	private int totalpage;		// 총 페이지
	private int startpage;		// 현제 페이지 시작 글번호
	private int endpage;		// 현제 페이지 마지막 글번호
	
	public Notice_page(int total, int cur, int size, List<Notice> cont) {
		this.total = total;
		this.curpage = cur;
		this.cont = cont;
		
		if(total == 0) {
			totalpage = 0;
			startpage = 0;
			endpage = 0;
		} else {
			totalpage = total / size;
			if(total % size > 0) {
				totalpage += 1;
			}
			int mval = curpage % 5;
			startpage = curpage / 5 * 5 + 1;
			if(mval == 0) {
				startpage -= 5;
			}
			endpage = startpage + 4;
			if(endpage > totalpage) {
				endpage = totalpage;
			}
		}
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public List<Notice> getCont() {
		return cont;
	}
	public void setCont(List<Notice> cont) {
		this.cont = cont;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	
}
