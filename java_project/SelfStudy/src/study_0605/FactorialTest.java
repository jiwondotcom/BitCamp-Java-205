package study_0605;

class FactorialTest {
	public static void main(String[] args) {
		
		System.out.println(factorial(4));
	}

	static long factorial(int n) {
		long result = 0;
		if (n == 1) {
			result = 1;
		} else {
			result = n * factorial(n-1);
			// 다시 메소드 자신을 호출한다.
			// 4 * {3 * (2 * 1)} = 24 - 출력값 
		}
		
		return result;
		
	}
}
 

// 삼항연산자 ? : 를 이용하면 더욱 간략하게 표현이 가능하다.

// static long factoiral(int n) {
//		return (n == 1) ? 1 : n * factorial(n-1);
// }
