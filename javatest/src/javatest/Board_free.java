package javatest;

import java.util.Scanner;

public class Board_free extends Board {
	public Board_free(String boardName) {
		super(boardName);
	}
	
	@Override
	public void write() {
		Scanner scan = new Scanner(System.in);
		System.out.println("게시글 번호를 입력하세요");
		int num = scan.nextInt();
		scan.nextLine();
		this.setNum(num);
		System.out.println("게시글 이름을 입력하세요");
		this.setTitle(		scan.nextLine()	);
		System.out.println("작성자 이름을 입력하세요");
		this.setAuthor(		scan.nextLine()	);
	}
	
	@Override
	public void list() {
		String str = this.getNum() + " / " + this.getTitle() + " / " + this.getAuthor();
		System.out.println(str);
	}
}
