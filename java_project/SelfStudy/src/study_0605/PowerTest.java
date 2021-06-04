package study_0605;

class PowerTest {
	public static void main(String[] args) {

		int x = 2;
		int n = 5;
		long result = 0;
		
		for(int i = 1; i <= n; i++) {
			result += power(x,i);
		}
		
		System.out.println(result);
	}

	static long power(int x, int n) {
		if (n == 1) {
			return x;
		}
		return x * power(x, n-1);
		
	}
}

// 출력값:
// power(2,1) + power (2,2) + power (2,3) + power(2,4) + power(2,5)
// 2 + (2 * power(2,1)) + (2 * power(2,2)) + (2 * power(2,3)) + (2 * power(2,4))
// 2 + 4 + 8 + 16 + 32 
// = 62
