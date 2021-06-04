package study_0605;

class MemberCall {

	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	// static int cv2 = iv;
	// error : 클래스변수는 인스턴스변수를 사용할 수 없다.
	
	static int cv2 = new MemberCall().iv;
	// 굳이 사용하고자 할때는 이처럼 객체를 생성해야 한다.
	
	static void classMethod1() {
		System.out.println(cv);
//		System.out.println(iv);
//	 	error : 클래스메서드에서 인스턴스 변수를 바로 사용할 수 없다.
		
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
		// 객체를 생성한 후에야 인스턴스변수의 참조가 가능하다.
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
		// 인스턴스메소드에서는 인스턴스변수를 바로 사용이 가능하다.
	}
	
	static void classMethod2() { 
		classMethod1(); 
		// instanceMethod1();
		// error : 클래스메소드에서는 인스턴스메소드를 바로 호출할 수 없다.
		
		MemberCall c = new MemberCall();
		c.instanceMethod1();
		// 인스턴스를 생성한 후에야 인스턴스메소드를 호출할 수 있다.
	}
	
	void instanceMethod2() {
		classMethod1();
		instanceMethod1();
		// 인스턴스메소드에서는 인스턴스메소드와 클래스메소드 모두
		// 인스턴스생성 없이 바로 호출이 가능하다.
	
	}

}
