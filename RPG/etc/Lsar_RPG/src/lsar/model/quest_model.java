package lsar.model;

public class quest_model {
	public quest_model(int num, String title, String cont, int q_level, int q_count, int type_code, String type,
			int reward_code, int reward) {
		super();
		this.num = num;
		this.title = title;
		this.cont = cont;
		this.q_level = q_level;
		this.q_count = q_count;
		this.type_code = type_code; // 퀘스트종류 코드
		this.type = type; // 퀘스트 종류 (아이템, 몬스터..)
		this.reward_code = reward_code; //퀘스트 보상 코드(경험치, 아이템...)
		this.reward = reward; // 퀘스트 보상
	}
	public quest_model(int num, String title, String cont, int q_level, int q_count, int type_code, String type,
			int reward_code, int reward,int achive) {
		super();
		this.num = num;
		this.title = title;
		this.cont = cont;
		this.q_level = q_level;
		this.q_count = q_count;
		this.type_code = type_code; // 퀘스트종류 코드
		this.type = type; // 퀘스트 종류 (아이템, 몬스터..)
		this.reward_code = reward_code; //퀘스트 보상 코드(경험치, 아이템...)
		this.reward = reward; // 퀘스트 보상
		this.achive=achive;
	}
	
	private int num;
	private String title;
	private String cont;
	private int q_level;
	private int q_count;
	private int type_code;
	private String type;
	private int reward_code;
	private int reward;
	private int achive;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public int getQ_level() {
		return q_level;
	}
	public void setQ_level(int q_level) {
		this.q_level = q_level;
	}
	public int getQ_count() {
		return q_count;
	}
	public void setQ_count(int q_count) {
		this.q_count = q_count;
	}
	public int getType_code() {
		return type_code;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getReward_code() {
		return reward_code;
	}
	public void setReward_code(int reward_code) {
		this.reward_code = reward_code;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public int getAchive() {
		return achive;
	}
	public void setAchive(int achive) {
		this.achive = achive;
	}
	
}
