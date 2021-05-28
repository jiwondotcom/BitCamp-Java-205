package study_0528;

class CastingTest {
	public static void main(String[] args) {

		Car02 car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe; // car = (Car)fe;에서 형변환이 생략된 형태
//		car.water(); // compile error : 참조변수로는 water()를 호출할 수 없다.

		fe2 = (FireEngine)car; // 자손타입 <- 조상타입
		fe2.water();
	
	}
}