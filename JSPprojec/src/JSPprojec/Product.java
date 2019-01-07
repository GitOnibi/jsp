package JSPprojec;

public class Product {

	private String	proNum,
					proName,
					proCol,
					proCnt,
					proPri;
	
	public Product() {
		
	}
	
	public Product( String proNum, String proName, String proCol, String proCnt, String proPri ) {
		this.proNum		= proNum;
		this.proName	= proName;
		this.proCol		= proCol;
		this.proCnt		= proCnt;
		this.proPri		= proPri;
	}
	
	public String proInfo() {
		return "proNum: " + proNum + " proName : " + proName + " proCol : " + proCol + " proCnt : " + proCnt + " proPri : " + proPri;
	}

	public String getProNum() {
		return proNum;
	}

	public void setProNum(String proNum) {
		this.proNum = proNum;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProCol() {
		return proCol;
	}

	public void setProCol(String proCol) {
		this.proCol = proCol;
	}

	public String getProCnt() {
		return proCnt;
	}

	public void setProCnt(String proCnt) {
		this.proCnt = proCnt;
	}

	public String getProPri() {
		return proPri;
	}

	public void setProPri(String proPri) {
		this.proPri = proPri;
	}
}