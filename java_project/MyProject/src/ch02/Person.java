package ch02;

public class Person {

	String name;
	String memberPhoneNum = "000-0000-0000";
	String perNum1 = "990101-2000000";
	long perNum2 = 9901012000000L;

	
	// 인스턴스 변수들의 데이터를 출력하는 메소드
	void showData() {
		System.out.println("회원 이름 : " + name);
		System.out.println("회원의 주민번호1 : " + perNum1);
		System.out.println("회원의 주민번호2 : " + perNum2);
	}

	
	public static void main (String[] args) {
		
		// Person 인스턴스 생성
		Person person = new Person();
		
		System.out.println("이름 : " + person.name);
		person.name = "짱구";
		person.showData();

	}
}
