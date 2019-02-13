package javatest;

public class Test {

	public static void main(String[] args) {
		Doctor d	= new Doctor(1, "김지혁", "내과의사", 43);
		Teacher t	= new Teacher(2, "이지혁", "초등교사", 65);
		
		System.out.println("---------------------------------------------");
		d.active();
		System.out.println(d.ment());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		t.active();
		System.out.println(t.ment());
		System.out.println("---------------------------------------------");
		
		Member[] pp = new Member[5];
		pp[0] = new Doctor(1, "김지혁", "내과의사", 43);
		pp[1] = new Teacher(2, "이지혁", "초등교사", 65);
		System.out.println("---------------------------------------------");
		pp[0].active();
		System.out.println(pp[0].ment());
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		pp[1].active();
		System.out.println(pp[1].ment());
		System.out.println("---------------------------------------------");
	}

}
