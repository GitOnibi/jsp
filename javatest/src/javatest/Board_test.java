package javatest;

public class Board_test {
	public static void main(String[] args) {
		Board[] bd = new Board[3];
		bd[0] = new Board_image("이미지 게시판");
		bd[1] = new Board_free("자유 게시판");
		bd[2] = new Board_admin("관리자 게시판");
		
		bd[0].write();
		bd[1].write();
		bd[2].write();
		
		for(int i = 0; i < 3; i++) {
			bd[i].list();
		}
	}
}
