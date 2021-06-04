package study_0605;

public class MyMathTest01 {
	public static void main(String[] args) {
		
		MyMath01 mm = new MyMath01();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);
		// 나누기값은 double 형식
		
		System.out.println("add(5L,3L) = " + result1);
		System.out.println("subtract(5L,3L) = " + result2);
		System.out.println("multiply(5L,3L) = " + result3);
		System.out.println("divide(5L,3L) = " + result4);
		
	}

}
