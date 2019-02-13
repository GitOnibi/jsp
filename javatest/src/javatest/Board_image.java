package javatest;

import java.util.Scanner;

public class Board_image extends Board {
	private String imageName;
	
	public Board_image(String boardName) {
		super(boardName);
	}
	
	@Override
	public void write() {
		Scanner scan = new Scanner(System.in);
		System.out.println("게시글 번호를 입력하세요");
		int num = scan.nextInt();
		scan.nextLine();
		this.setNum(num);
		System.out.println("게시글 제목을 입력하세요");
		this.setTitle(		scan.nextLine()	);
		System.out.println("이미지 이름을 입력하세요");
		this.setImageName(	scan.nextLine()	);
		System.out.println("작성자 이름을 입력하세요");
		this.setAuthor(		scan.nextLine()	);
	}
	
	@Override
	public void list() {
		String str = this.getNum() + " / " + this.getTitle() + " / " + this.getImageName() + " / " + this.getAuthor();
		System.out.println(str);
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	};
}
