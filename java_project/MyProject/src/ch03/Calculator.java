package ch03;

import java.util.Scanner;

//1. Calculator 클래스를 정의해봅시다.
//① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
//② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
//③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
//④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
//⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의
//⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의
//원의 둘레 : 2 x π x r , 원의 넓이 : π x r x r
//⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
//⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
//에 추가해봅시다.


public class Calculator {
	
	public int plus(int a, int b) {
		return a + b;
	}
	public int minus(int a, int b) {
		return a - b;
	}
	public int multi(int a, int b) {
		return a * b;
	}
	public int div(int a, int b) {
		return a / b;
	}
	public double circleAround (double r) {
		return (2 * Math.PI * r);
	}
	
	public double circleArea (double r) {
		return (Math.PI * r * r);
	}
	
	public static int getIntInput(Scanner scanner) {
		return scanner.nextInt();
	}
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int a = getIntInput(scanner);
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int b = getIntInput(scanner);
		
		System.out.println("===========================");

		System.out.println(">> 덧셈 : " + cal.plus(a, b));
		System.out.println(">> 뺄셈 : " + cal.minus(a, b));
		System.out.println(">> 곱셈 : " + cal.multi(a, b));
		System.out.println(">> 나눗셈 : " + cal.div(a, b));
		System.out.println("===========================");
		
		System.out.print("1. 반지름을 입력하세요 : ");
		double r1 = getIntInput(scanner);
		System.out.println("원의 둘레 : " + (2 * Math.PI * r1));
		System.out.println("원의 넓이 : " + (Math.PI * r1 * r1));
		System.out.println("===========================");
		
		System.out.print("2. 반지름을 입력하세요 : ");
		double r2 = getIntInput(scanner);
		System.out.println("원의 둘레 : " + (2 * Math.PI * r2));
		System.out.println("원의 넓이 : " + (Math.PI * r2 * r2));
		System.out.println();
		
	}
}