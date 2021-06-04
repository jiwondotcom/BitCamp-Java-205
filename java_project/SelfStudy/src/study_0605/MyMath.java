package study_0605;

class MyMath {
	
	long add (long a, long b) {
		long result = a + b;
		return result;
		// return a + b; 
		// 위의 두줄을 이와 같이 한줄로 간단히 축약 가능.
	}
	
	long subtract (long a, long b) {
		return a - b;
	}
	
	long multiply (long a, long b) {
		return a * b;
	}
	
	double divide (double a, double b) {
		return a / b;
	}

}
