package JSPprojec;

public class Info {
	private int num;
	private String name;
	private String p_num;
	
	public Info() {
		
	}
	public Info(int num, String name, String p_num) {
		this.num = num;
		this.name = name;
		this.p_num = p_num;
	}
	
	public String printAll() {
		String str = "순번 : " + this.num + " / 이름 : " + this.name + " / 품번 : " + this.p_num;
		return str;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	
}