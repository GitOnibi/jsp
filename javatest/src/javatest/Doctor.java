package javatest;

public class Doctor extends Member {
	public Doctor(int num, String name, String job, int age) {
		super(num, name, job, age);
	}
	
	@Override
	public void active() {
		System.out.println(getName() + " 의사선생님이 진찰한다.");
	}
	
	@Override
	public String ment() {
		String str = "나는 " + getAge() + "살이며 직업은 " + getJob() + "이다.";
		return str;
	}
}
