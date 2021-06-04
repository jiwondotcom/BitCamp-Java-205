package study_0605;

class CallStackTest02 {
	public static void main(String[] args) {
		
		System.out.println("main(String[] args)이 시작되었습니다.");
		firstMethod();
		System.out.println("main(String[] args)이 끝났습니다.");
	}
	
	static void firstMethod() {
		System.out.println("fistMethod()가 시작되었습니다.");
		secondMethod();
		System.out.println("fistMethod()가 끝났습니다.");
	}

	static void secondMethod() {
		System.out.println("secondMethod()가 시작되었습니다.");
		System.out.println("secondMethod()가 끝났습니다.");
	}

}

