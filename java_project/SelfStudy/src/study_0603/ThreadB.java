package study_0603;

public class ThreadB extends Thread {

	public void run() {
		// ThreadB 실행 내용
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}

	}

}
