package ch07;

public class Female extends Person{

	public String likeFruit;
	
	public Female (String name, int frontSsn, String likeFruit) {
		super(name, frontSsn);
		this.likeFruit = likeFruit;
	}

	void femaleInfo() {
		super.greeting();
	}
	
	void eating() {
		System.out.println("좋아하는 과일은 " + likeFruit + "입니다.");
	}
}
