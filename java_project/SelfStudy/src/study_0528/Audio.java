package study_0528;

public class Audio extends Product {
	
	Audio() { // 조상클래스의 생성자 Product(int pirce)를 호출한다.
		super(50);
		// Audio의 가격을 50만원으로 저장
	}
	
	public String toString() { // Object클래스의 toString()을 오버라이딩한다.
		return "Audio"; 
	}

}
