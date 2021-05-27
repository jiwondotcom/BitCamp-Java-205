package test;

import java.util.Scanner;

//다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값의 크기만큼 전부 증가시킨다.
//
//﻿public static void addOneDArr(int[] arr, int add){
//         for (int i=0, i<arr.length; i++)
//         arr[i] +=add; }
//﻿
//이 메서드를 기반으로 (이 메서들르 호출하는 형태로)
//int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
//public static void addOneDArr(int[][] arr, int add) { . . . . . }
//단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며,
//위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.

public class addArray {
	private static int[][] setMultiArr() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 행, 몇 열의 배열을 만드시겠습니까?");
		System.out.print("# 행: ");
		int a = sc.nextInt();
		System.out.print("# 열: ");
		int b = sc.nextInt();
		
		int[][] multiArr = new int[a][b];
			return multiArr;
	}

	
	private static void arrInput (int[][] multiArr) {
		Scanner sc = new Scanner(System.in);

	System.out.println("▶ 배열을 이루는 값을 각각 입력해주세요 ◀");
	for (int i = 0; i < multiArr.length; i++) {
		for (int j = 0; j < multiArr[i].length; j++) {
			System.out.print("배열[" + i + "][" + j + "]의 값: ");
	multiArr[i][j] = sc.nextInt();
}
	}
}
	
	public static void addOneDArr (int[][] multiArr, int add) {
		// 2차원배열 multiArr의 모든 요소에 int add만큼의 값을 더한다. (for문)
		for (int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
				multiArr[i][j] += add;
			}
		}		
	}
		
	
	public static void nowArr (int[][] multiArr) {
		for (int i = 0; i < multiArr.length; i++) { 
			for (int j = 0; j < multiArr[i].length; j++) {
			// for (int i ...) ~ for (int j ...) : 배열을 순서대로 출력하는 for문
			System.out.print(multiArr[i][j] + " "); 
		} 	System.out.println();	
			} 	
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] multiArr = setMultiArr();
		// 2차원 배열 multiArr의 길이를 세팅하는 메소드 실행
		arrInput(multiArr);
		// 배열의 각 요소값을 multiArr배열에 저장하는 메소드 실행
		System.out.println("\n[ 배열 ]");
		nowArr(multiArr);
		System.out.print("\n얼마를 더하겠습니까? >> ");
		int add = sc.nextInt();
		addOneDArr(multiArr, add);
		// 사용자에게 직접 입력받은 숫자(add)만큼 모든 배열 요소에 값을 더하는 메소드 실행
		System.out.println("\n>>> 순서 변경 후 <<< ");
		System.out.println("[ 배열 ]");
		nowArr(multiArr);

	
		
	}
}
