package JSPprojec;

public class Order {
	
	private int chairNum;
	private int chairPrice;
	private int deskNum;
	private int deskPrice;
	
	public Order() {
		
	}
	public Order( int chairNum, int chairPrice, int deskNum, int deskPrice ) {
		this.chairNum 	= chairNum;
		this.chairPrice	= chairPrice;
		this.deskNum 	= deskNum;
		this.deskPrice	= deskPrice;
	}
	
	public int getChairNum() {
		return chairNum;
	}
	public void setChairNum(int chairNum) {
		this.chairNum = chairNum;
	}
	public int getChairPrice() {
		return chairPrice;
	}
	public void setChairPrice(int chairPrice) {
		this.chairPrice = chairPrice;
	}
	public int getDeskNum() {
		return deskNum;
	}
	public void setDeskNum(int deskNum) {
		this.deskNum = deskNum;
	}
	public int getDeskPrice() {
		return deskPrice;
	}
	public void setDeskPrice(int deskPrice) {
		this.deskPrice = deskPrice;
	}
	
	public int getTotal() {
		return (chairNum * chairPrice) + (deskNum * deskPrice);
	}
	
}
