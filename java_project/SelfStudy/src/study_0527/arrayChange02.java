package study_0527;

import java.util.Scanner;

//		다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//		1 2 3
//		4 5 6
//		7 8 9
//
//		이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//		7 8 9
//		1 2 3
//		4 5 6
//		즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다.
//		이번에도 마찬가지로 배열의 가로, 세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며,
//		정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.

public class arrayChange02 {
	public static int[][] setMultiArr() {
		// multiArr 배열의 행과 열을 사용자에게 직접 값을 입력받아 2차원 배열의 길이를 세팅하는 메소드
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 행, 몇 열의 배열을 만드시겠습니까?");
		System.out.print("＃ 행: ");
		int a = sc.nextInt();
		System.out.print("# 열: ");
		int b = sc.nextInt();
		
		int[][] multiArr = new int[a][b];
			return multiArr;
	}

	public static void arrInput(int[][] multiArr) {
		// multiArr 배열의 요소를 사용자에게 직접 값을 입력받아 저장하는 메소드
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < multiArr.length; i++) {
			for (int j = 0; j < multiArr[i].length; j++) {
		System.out.print("▶ 배열[" + i + "][" + j + "]의 값: ");
		multiArr[i][j] = sc.nextInt();
	}
		}	
	}

	public static void arrChange (int[][] multiArr) { 
		// multiArr 배열의 순서를 바꾸는 메소드
		int[] tmp;
		for (int i = multiArr.length-1; i > 0; i--) {
			tmp = multiArr[i]; 
			multiArr[i] = multiArr[i-1]; 
			multiArr[i-1] = tmp;
		} 
	}
/*
	(i는 0보다 크고 배열의 길이인 3보다 작다 / for구문은 2번만 돈다)
	(배열의 가장 작은 인덱스값은 0)
	(i가 0이 되면 (multiArr-length - 1) 값이 음수가 되므로 for문 성립X)
	
	<기존 배열>
	1 2 3
	4 5 6
	7 8 9
	
	<첫번째 셔플> i = 2;
	=> [2]와 [1]교체 후 :
	1 2 3
	7 8 9
	4 5 6
	
	<두번째 셔플> i = 1; (첫번째 i값보다 -1)
	=> [1]과 [0]교체 후 : 
	7 8 9
	1 2 3
	4 5 6
*/	
	public static void nowArr (int[][] multiArr) {
		for (int i = 0; i < multiArr.length; i++) { 
			for (int j = 0; j < multiArr[i].length; j++) {
			// for (int i ...) ~ for (int j ...) : 배열을 순서대로 출력하는 for문
			System.out.print(multiArr[i][j] + " "); 
		} 	System.out.println();	
			} 	
	}
	
	public static void main(String[] args) {
		int[][] multiArr = setMultiArr();
		// 2차원 배열 multiArr의 길이를 세팅하는 메소드 실행
		arrInput(multiArr);
		// 배열의 각 요소값을 multiArr배열에 저장하는 메소드 실행
		System.out.println("\n[ 배열 ]");
		nowArr(multiArr);
		// multiArr배열의 현재 상황을 출력하는 메소드 실행
		arrChange(multiArr);
		// multiArr배열의 순서를 변경하는 메소드 실행 
		System.out.println("\n>>> 순서 변경 후 <<< \n");
		// 배열 순서 변경 전 후 - 구분선
		System.out.println("[ 배열 ]");
		nowArr(multiArr);
		// 배열 순서 변경 후 multiArr배열의 현재 상황을 최종적으로 재출력
		
	}

}
