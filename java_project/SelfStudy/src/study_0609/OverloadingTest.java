package study_0609;

public class OverloadingTest {
	public static void main(String[] args) {

		MyMath2 mm2 = new MyMath2();
		System.out.println("mm2.add(3,3) 결과 : " + mm2.add(3,3));
		System.out.println("mm2.add(3L,3) 결과 : " + mm2.add(3L,3));
		System.out.println("mm2.add(3,3L) 결과 : " + mm2.add(3,3L));
		System.out.println("mm2.add(3L,3L) 결과 : " + mm2.add(3L,3L));
	
		int[] a = {100, 200, 300};
		System.out.println("mm2.add(a) 결과 : " + mm2.add(a));
		
	}

}

class MyMath2 {
	int add(int a, int b) {
		System.out.println("int add(int a, int b) - ");
		return a + b;
	}
		
	long add(int a, long b) {
		System.out.println("long add(int a, int b) - ");
		return a + b;
	}

	long add(long a, long b) {
		System.out.println("long add(long a, long b) - ");
		return a + b;
	}
	
	int add(int[] a) { // 배열의 모든 요소의 합을 결과로 돌려준다.
		System.out.println("int add(int[] a) - ");
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	
	}

} // end of class