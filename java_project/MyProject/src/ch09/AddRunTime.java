package ch09;

// 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다.

public class AddRunTime {
	public static void main(String[] args) {
		
		int total = 0; // total값은 0으로 초기화
		long startTime; 
		long endTime; 
		
		startTime = System.nanoTime(); // 시작시간
		for (int i = 0; i <100000000; i++) {
			total += (i+1); // total + (i+1) 값은 total에 저장
		} 
		endTime = System.nanoTime(); // 종료시간
		
		System.out.println("덧셈 소요시간: " + (endTime - startTime));

	}

}
