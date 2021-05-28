package study_0528; 

public class PolyArgumentTest2 {
	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audio = new Audio();
		
		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		
		b.summary(); // summary 메소드 호출

	}

}
