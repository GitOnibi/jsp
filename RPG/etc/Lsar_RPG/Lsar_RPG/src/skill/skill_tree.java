package skill;

public class skill_tree {
	private int code;
	private String name;
	private String type;
	private String kind;
	private int option1;
	private int option2;
	private int option3;
	private int option4;
	private String using;
	public skill_tree(int code,String name, String type, String kind, int option1, int option2, int option3, int option4, String use) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.kind = kind;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.using = use;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	public String getUsing() {
		return using;
	}
	public void setUsing(String using) {
		this.using = using;
	}
}
