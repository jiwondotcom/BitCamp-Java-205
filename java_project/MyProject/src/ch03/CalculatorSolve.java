package ch03;

import java.util.Scanner;

public class CalculatorSolve {
	
	// 클래스이름 => 대문자 시작 케멀 케이스
	// 변수 이름 => 소문자 시작 케멀 케이스
	// 상수 => 모두 대문자
	double pi1 = 3.14d;
	float pi2 = 3.14f;
	final float PI = 3.14f; // 한번 초기화되면 값을 변경할 수 없는 final타입


//① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	long plus (int num1, int num2) {
//		long result = num1 + num2;
//		return result;
		return (long)num1+num2;
		// 반환타입과 일치시켜야한다.
	}
	
//② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	long minus (int num1, int num2) {
		return (long)num1-num2;
	}	
		
//③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	long multi (int num1, int num2) {
		return (long)num1*num2;
	}
		
//④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	float div (int num1, int num2) {
		return (float)num1/num2;
		// (float)int / int -> int
	}

	
	
//원의 둘레 : 2 x π x r , 원의 넓이 : π x r x r
//⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
	float cirCum(float r) {
		return 2*PI*r;
		// int * float * float = float * float = float
	}
	
//⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
	float cirArea(float r) {
		return PI*r*r;
	}
	
//⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
//⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
//에 추가해봅시다.
	
	public static void main(String[] args) {
		CalculatorSolve calSo = new CalculatorSolve();
	
		System.out.println(calSo.PI);
		System.out.println("1 + 2 = " + calSo.plus(1,2));
		
		// Scanner : 자원을 프로그램으로 받아보는 역할
		Scanner scanner = new Scanner(System.in);
		
		
		// 덧셈
		System.out.println("덧셈을 합니다. \n숫자 1을 입력해주세요.");
		int num1 = scanner.nextInt();
		System.out.println("숫자 2를 입력해주세요.");
		int num2 = scanner.nextInt();
		System.out.println(num1 + " + " + num2 + " = " + calSo.plus(num1, num2));
	
		System.out.println("=================================");
		
		System.out.println("반지름을 입력해주세요.");
		float r = scanner.nextFloat();
		System.out.println("입력 받은 반지름의 길이 : " + r) ;
		System.out.println("원의 둘레 : "  + calSo.cirCum(r));
		System.out.println("원의 넓이 : "  + calSo.cirArea(r));
		
		System.out.println("반지름을 입력해주세요.");
		float r2 = scanner.nextFloat();
		System.out.println("입력 받은 반지름의 길이 : " + r2) ;
		System.out.println("원의 둘레 : "  + calSo.cirCum(r2));
		System.out.println("원의 넓이 : "  + calSo.cirArea(r2));
		
	}
	
}
