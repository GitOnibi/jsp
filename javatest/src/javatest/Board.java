package javatest;

public abstract class Board {
	private String boardName;
	private int num;
	private String title;
	private String author;
	private int hit;
	
	public Board() {}
	
	public Board(String boardName) {
		this.boardName	= boardName;
	}
	
	public abstract void write();
	public abstract void list();

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
// getter setter
	
}
