package study_0528;

class Tv extends Product{
	
	Tv() {
		super(100); // 조상클래스의 생성자 Product(int pirce)를 호출한다.
		// Tv의 가격을 100만원으로 저장
	}
	
	public String toString() { // Object클래스의 toString()을 오버라이딩한다.
		return "Tv";
	}

}
