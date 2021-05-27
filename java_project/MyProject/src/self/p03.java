package self;

import java.util.Scanner;

public class p03 {
//	다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//	1 2 3
//	4 5 6
//	7 8 9
//
//	이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//	7 8 9
//	1 2 3
//	4 5 6
//	즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다.
//	이번에도 마찬가지로 배열의 가로, 세로길이에 상관 없이 동작을 하도록 메서드가 정의되어야 하며, 정의된 메서드의 확인을 위한 main메서드도 함께 정의하자.



		private static int[][] setMultiArr() {
			System.out.println("몇 행 몇 열의 배열을 만드시겠습니까?");
			System.out.print("-행 : ");
			int row = getInputInt();
			System.out.print("-열 : ");
			int column = getInputInt();
			
			int[][] multiArr = new int[row][column];
			// 사용자에게 입력받은 값(행과 열의 개수)를 배열 multiArr에 입력, 생성
			return multiArr; 
		}

		private static void setMultiArrRe(int[][] multiArr) {
			for (int i = 0; i < multiArr.length; i++) {
				for (int j = 0; j < multiArr[i].length; j++) {
					System.out.print("▶ 배열[" + (i+1)+ "][" + (j+1) + "] 값 : ");
					multiArr[i][j] = getInputInt();
				// 배열 multiArr의 요소 세팅 완료
				}
			}
		}
		
		public static void changeArr(int[][] multiArr) {
			int[] temp;
	        for (int i = multiArr.length-1; i > 0; i--) { // 2번 섞기 (배열 multiArr의 길이는 3이므로 2부터~1까지)
	            temp = multiArr[i]; 
	            multiArr[i] = multiArr[i-1]; 
	            multiArr[i-1] = temp; 
	        } 
	    }

		private static void nowArr(int[][] multiArr) {
			System.out.println("[배열]");
			for(int i = 0; i < multiArr.length; i++) {
				for (int j = 0; j < multiArr[i].length; j++) {
					System.out.print(multiArr[i][j] + " ");
				}
				System.out.println();
			}
		}
		public static void main(String[] args) {
			int[][] multiArr = setMultiArr();
			setMultiArrRe(multiArr);
			System.out.println();
			nowArr(multiArr);
			System.out.println("\n>>>>>>>> 순서변경  <<<<<<<<\n");
			changeArr(multiArr);
			nowArr(multiArr);
			
			
		}
		
		private static int getInputInt() {
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	return Integer.parseInt(input);
	
}
	
}
