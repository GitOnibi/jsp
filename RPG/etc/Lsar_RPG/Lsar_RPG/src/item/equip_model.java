package item;
/*
 * type 1 = 무기 - 검
 *      2=  무기 - 도끼
 *      3 = 무기 - 창
 *      4 = 무기 - 활
 *      5 = 무기 - 지팡이
 *      6 = 방어구 - 투구
 *      7 = 방어구 - 방패
 *      8 = 방어구 - 갑옷
 *      9 = 방어구 - 다리
 *      10 = 방어구 - 장갑
 *      11 = 기타 
 *  option 1 = 무기 - 물리공격력
 *         2 = 무기 - 마법력
 *         3 = 무기 - 신성력
 *         4 = 무기 - 방어 무시
 *         1 = 방어구 - 방어력
 *         2 = 방어구 - hp
 *         3 = 방어구 - mp
 *         4 = 방어구 - dp
 */
public class equip_model {
	public equip_model(int code, String equip_name, String equip_type, int option1, int option2, int option3,
			int option4, String part) {
		super();
		this.code = code;
		this.equip_name = equip_name;
		this.equip_type = equip_type;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.part = part;
	}
	public equip_model(int code, String equip_name, String equip_type, int option1, int option2, int option3,
			int option4, String part, int type,String using,int prof,int achive,int num) {
		super();
		this.code = code;
		this.equip_name = equip_name;
		this.equip_type = equip_type;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.part = part;
		this.type=type;
		this.using=using;
		this.prof=prof;
		this.achive=achive;
		this.num=num;
	}
	private int code;
	private String equip_name;
	private String equip_type;
	private int option1;
	private int option2;
	private int option3;
	private int option4;
	private String part;
	private int type;
	private String using;
	private int prof;
	private int achive;
	private int num;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	public String getEquip_type() {
		return equip_type;
	}
	public void setEquip_type(String equip_type) {
		this.equip_type = equip_type;
	}
	public int getOption1() {
		return option1;
	}
	public void setOption1(int option1) {
		this.option1 = option1;
	}
	public int getOption2() {
		return option2;
	}
	public void setOption2(int option2) {
		this.option2 = option2;
	}
	public int getOption3() {
		return option3;
	}
	public void setOption3(int option3) {
		this.option3 = option3;
	}
	public int getOption4() {
		return option4;
	}
	public void setOption4(int option4) {
		this.option4 = option4;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUsing() {
		return using;
	}
	public void setUsing(String using) {
		this.using = using;
	}
	public int getProf() {
		return prof;
	}
	public void setProf(int prof) {
		this.prof = prof;
	}
	public int getAchive() {
		return achive;
	}
	public void setAchive(int achive) {
		this.achive = achive;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}