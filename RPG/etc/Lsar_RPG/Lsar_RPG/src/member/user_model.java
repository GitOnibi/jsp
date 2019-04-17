package member;

public class user_model {
	private int id;
	private int num; // 아이템 연결번호
	private int type; //아이템종류
	private int using; //사용여부
	private int prof;//숙련도
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUsing() {
		return using;
	}
	public void setUsing(int using) {
		this.using = using;
	}
	public int getProf() {
		return prof;
	}
	public void setProf(int prof) {
		this.prof = prof;
	}
}
