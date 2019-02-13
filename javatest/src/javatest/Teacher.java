package javatest;

import java.util.Scanner;

public class Teacher extends Member {
	public Teacher(int num, String name, String job, int age) {
		super(num, name, job, age);
	}
	
	@Override
	public void active() {
		String str = getName() + " 선생님이 교실로 들어오셨다.";
		Scanner scan = new Scanner(System.in);
		int grade = scan.nextInt();
		System.out.println(str);
		System.out.println(grade + "학년 교실이다.");
	}
	
	@Override
	public String ment() {
		String str = "오늘은 국어 수업을 하겠다.";
		return str;
	}
}
