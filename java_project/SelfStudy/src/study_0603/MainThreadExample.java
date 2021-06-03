package study_0603;

public class MainThreadExample {
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		User1 u1 = new User1();
		u1.setCalculator(calc);
		u1.start();
		
		User2 u2 = new User2();
		u2.setCalculator(calc);
		u2.start();
		
	}

}
