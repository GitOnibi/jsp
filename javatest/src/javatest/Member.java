package javatest;

public abstract class Member {
	private int num;
	private String name;
	private String job;
	private int age;
	
	public Member() {}
	
	public Member(int num, String name, String job, int age) {
		this.num	= num;
		this.name	= name;
		this.job	= job;
		this.age	= age;
	}
	
	public abstract void active();
	public abstract String ment();

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
