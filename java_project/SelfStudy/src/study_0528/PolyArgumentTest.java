package study_0528;

public class PolyArgumentTest {
	public static void main(String[] args) {
	
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);
		b.buy(com);
		
		System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
		System.out.println("현재 포인트 점수는 " + b.bonusPoint + "점 입니다.");

	}

}
