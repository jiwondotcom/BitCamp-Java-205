package study_0604;

class TvTest03 {
	public static void main(String[] args) {
	
	Tv t1 = new Tv();
	Tv t2 = new Tv();
	System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
	System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
	
	t2 = t1; // t1이 저장하고 있는 값(주소)을 t2에 저장한다.
			 // 우변 값을 -> 좌변에 저장
			 // 이 문장이 수행되면, t2가 가지고 있던 값은 잃어버리게 되고,
			 // t1에 저장되어있던 값이 t2에 저장되게 된다.
	// t2 역시 t1이 참조하고 있던 인스턴스를 같이 참조하게 되고,
	// t2가 원래 참조하고 있던 인스턴스는 더 이상 사용할 수 없게 된다.
	t1.channel = 7; // channel값을 7로 설정
	System.out.println("t1의 channel 값을 " + t1.channel + "로 변경하였습니다.");
	
	
	System.out.println("t1의 cha"
			+ "nnel값은 " + t1.channel + "입니다.");
	System.out.println("t1의 channel값은 " + t2.channel + "입니다.");
	
	}

}
