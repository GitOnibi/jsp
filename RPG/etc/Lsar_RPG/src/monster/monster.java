package monster;

public class monster {
	public monster(int num, String mon_name, int level, int attack, int def, int hp, int mp, int dp, String kind,
			String item_list,int f_num) {
		super();
		this.num = num;
		this.mon_name = mon_name;
		this.level = level;
		this.attack = attack;
		this.def = def;
		this.hp = hp;
		this.mp = mp;
		this.dp = dp;
		this.kind = kind;
		this.item_list = item_list;
		this.f_num=f_num;
	}
	private int num;
	private String mon_name;
	private int level;
	private int attack;
	private int def;
	private int hp;
	private int mp;
	private int dp;
	private String kind;
	private int f_num;
	private String item_list;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMon_name() {
		return mon_name;
	}
	public void setMon_name(String mon_name) {
		this.mon_name = mon_name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getDp() {
		return dp;
	}
	public void setDp(int dp) {
		this.dp = dp;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getItem_list() {
		return item_list;
	}
	public void setItem_list(String item_list) {
		this.item_list = item_list;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
}
