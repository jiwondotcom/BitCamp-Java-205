package ch02;

// ch02.Member
public class Member {
	public static void main(String[] args) {
	
	//인스턴스 변수
	String name = "황짱구";
	int age = 5;
	double height = 171.4;
	boolean hasBook = false;
	
	System.out.println("이름은 " + name); // String + String
	System.out.println("키는 " + height + "cm 입니다."); // String + double + String
	System.out.println("나이는 " + age + "세 입니다."); // String + int + String
	System.out.println("JAVA책의 보유 여부 : " + hasBook); // String + boolean
	// String + anyType -> String + String
	
	if(hasBook == true) {
		System.out.println("보유하고 있습니다.");
	} else { 
		System.out.println("보유하고 있지 않습니다.");
	}

	
	// 변수 선언
	// 데이터의 타입 식별 이름
	// 데이터 타입 -> 내가 다루어야 하는 데이터의 특징에 의해서 결정
	// 기본형 타입 8가지 -> 정수형, 실수형, boolean, 문자형 
	// 정수형 (byte, short, integer) - 표현할 수 있는 숫자의 범위가 상이함
		
	// 메소드 안에서 정의 되는 변수 -> 지역변수

		
	
	}

}