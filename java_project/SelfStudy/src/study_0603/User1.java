package study_0603;

public class User1 extends Thread {
	private Calculator calc;
	
	public void setCalculator(Calculator calc) {
		this.setName("User1"); // 스레드 이름을 User1로 설정
		this.calc = calc; // 공유 객체인 calc를 필드에 저장
	}
	
	public void run() {
		calc.setMemory(100); // 공유객체인 Calculator의 메모리에 100을 저장
	}
}
