package study_0605;

class CallStackTest01 {
	public static void main(String[] args) {
		
		firstMethod();
	}

	static void firstMethod() {
		secondMethod();
	}
	
	static void secondMethod() {
		System.out.println("secondMethod()");
	}
}

