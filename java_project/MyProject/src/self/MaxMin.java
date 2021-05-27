package self;

import java.util.Scanner;

//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
// public static int miniValue(int[] arr) { . . . . } // 최소값 반환
// public static int maxValue(int[] arr) { . . . . } // 최대값 반환
//
//위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//두 매소드 실행을 확인인하기 위한 main 메소드 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//임의로 결정

public class MaxMin {
	public static void main(String[] args) {
		
	int arrNum;
	System.out.print("몇개의 숫자를 입력하시겠습니까>> ");
	arrNum = getInputInt();
	
	int[] number = new int[arrNum];
	// 배열 number는 입력받은 숫자 arrNum개로 이루어져있다.
	
	for (int i = 0; i < number.length; i++) {
		System.out.print("■ 입력" + (i+1) + ": ");
		number[i] = getInputInt();
	// 입력받은 숫자들을 number라는 배열의 [i]값에 각각 순서대로 입력
	}
	
	System.out.println("====================");
	System.out.println(">> 최대값 : " + maxValue(number));
	System.out.println(">> 최소값 : " + minValue(number));

	}
	
	public static int maxValue(int[] arr) {
		int maxValue = arr[0];
	
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > maxValue) {
					maxValue = arr[i];
			} 
				} return maxValue;
	}

	public static int minValue(int[] arr) {
		int minValue = arr[0];
				
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < minValue) {
					minValue = arr[i];
			} 
				} return minValue;
	}
			

private static int getInputInt() {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	return Integer.parseInt(input);
	
	}
}

