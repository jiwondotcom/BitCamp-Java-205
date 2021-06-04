package study_0605;

public class MyMath02 {

	long a, b;
	
	// 인스턴스변수 a, b를 이용한 작업을 하므로 매개변수가 필요없다.
	long add() {
		return a + b;
	}
	long subtract() {
		return a - b;
	}
	long multiply() {
		return a * b;
	}
	double divide() {
		return a / b;
	}

	
	// 인스턴스변수와 관계없이 매개변수만으로도 작업이 가능하다.
	static long add2(long a, long b) {
		return a + b;
	}
	static long subtract2(long a, long b) {
		return a - b;
	}
	static long multiply2(long a, long b) {
		return a * b;
	}
	static double divide2(long a, long b) {
		return a / b;
	}
	
}
