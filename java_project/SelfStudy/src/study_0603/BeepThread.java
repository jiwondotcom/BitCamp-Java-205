package study_0603;

import java.awt.Toolkit;

public class BeepThread extends Thread{

	@Override
	public void run() {
		// 스레드 실행 내용
		Toolkit tk = Toolkit.getDefaultToolkit();
		for(int i = 0; i < 5; i++) {
			tk.beep();
		} try {
			Thread.sleep(500); 
		} catch (Exception e) {
			}
	}

}
