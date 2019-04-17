package info;

import java.util.List;

public class notice_page {
	private int total;
	private int curpage; //현재선택페이지
	private List<notice> cont;
	private int totalpage; //총페이지
	private int startpage; // 현재 선택페이지에서 시작번호
	private int endpage; // 현재 선택페이지에서 끝번호
	
	public notice_page(int total, int cur,int size, List<notice> cont) {
		this.total=total;
		this.curpage=cur;
		this.cont=cont;
		if(total==0) {
			totalpage=0;
			startpage=0;
			endpage=0;
		}else {
			totalpage=total/size;
			if(total% size >0) {
				totalpage++;
			}
			int mval = curpage % 5;
			startpage=curpage/5 * 5+1;
			if(mval==0) startpage -= 5;
			
			endpage= startpage+4;
			
			if(endpage> totalpage) endpage=totalpage;
			
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
	public List<notice> getCont() {
		return cont;
	}
	public void setCont(List<notice> cont) {
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
