package study_0605;

public class MyMathTest02 {
	public static void main (String[] args) {
	
		
		// 클래스메소드 호출 (static)
		System.out.println(MyMath02.add2(200L, 100L));
		System.out.println(MyMath02.subtract2(200L, 100L));
		System.out.println(MyMath02.multiply2(200L, 100L));
		System.out.println(MyMath02.divide2(200L, 100L));
	
		MyMath02 mm = new MyMath02();
		mm.a = 200L;
		mm.b = 100L;
		
		// 인스턴스메소드는 객체생성 후에만 호출이 가능하다.
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
	
		
	}
}
