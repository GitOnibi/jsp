package member;

public class avatar_model {
	private String id; //아이디
	private int level; //레벨
	private String rank; //등급
	private String national;
	private int hp; //활력
	private int mp; // 마력
	private int dp; //신성력
	private int sword; //검술
	private int spell; //마법
	private int divine; //신성
	private int fatigue;//피로도
	private int attack;
	private int def;
	private int ex_p;
	private int ex_now;
	
	public avatar_model() {}
	public avatar_model(String id, int level,String rank, int hp,int mp,int dp, int sword,int spell,int divine,int fatigue,String national,int attack,int def,int ex_p,int now) {
		this.id=id; //아이디
		this.level=level; //레벨
		this.rank=rank; //등급
		this.hp=hp; //활력
		this.mp=mp; // 마력
		this.dp=dp; //신성력
		this.sword=sword; //검술
		this.spell=spell; //마법
		this.divine=divine; //신성
		this.fatigue=fatigue;//피로도
		this.national=national;
		this.attack=attack;
		this.def=def;
		this.ex_p=ex_p;
		this.ex_now=now;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
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
	public int getSword() {
		return sword;
	}
	public void setSword(int sword) {
		this.sword = sword;
	}
	public int getSpell() {
		return spell;
	}
	public void setSpell(int spell) {
		this.spell = spell;
	}
	public int getDivine() {
		return divine;
	}
	public void setDivine(int divine) {
		this.divine = divine;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
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
	public int getEx_p() {
		return ex_p;
	}
	public void setEx_p(int ex_p) {
		this.ex_p = ex_p;
	}
	public int getEx_now() {
		return ex_now;
	}
	public void setEx_now(int ex_now) {
		this.ex_now = ex_now;
	}
}
