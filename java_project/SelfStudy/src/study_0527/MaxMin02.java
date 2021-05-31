package study_0527;

import java.util.Scanner;

//int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
//public static int miniValue(int[] arr) { . . . . } // 최소값 반환
//public static int maxValue(int[] arr) { . . . . } // 최대값 반환
//
//위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//두 매소드 실행을 확인인하기 위한 main 메소드 정의.
//int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//임의로 결정

public class MaxMin02 {
	public static void main(String[] args) {

		int inx;
		System.out.print("입력할 숫자의 개수 : ");
		inx = getInputInt(); 
		
		int[] numArr = new int[inx];
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.print("입력" + (i+1) + ": ");
			numArr[i] = getInputInt();
		}
		
		System.out.println("===================");
		System.out.println("최대값 : " + maxValue(numArr));
		System.out.println("최소값 : " + minValue(numArr));
	}
	
	public static int maxValue(int[] arr) {
		int maxValue = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			} 
		}
			return maxValue;
	}	

	
	public static int minValue(int[] arr) {
		int minValue = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < minValue) {
				minValue = arr[i];
			}
		} 
			return minValue;
	}
	
	
	
	private static int getInputInt() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return Integer.parseInt(input);
	}

}
