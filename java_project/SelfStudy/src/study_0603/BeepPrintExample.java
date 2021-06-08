package study_0603;

import java.awt.Toolkit;

// 비프음을 모두 발생한 후, 출력을 시작한다.
public class BeepPrintExample {
	public static void main(String[] args) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // toolkit 객체 얻기
		for(int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 발생
			try {
				Thread.sleep(500); // 0.5초간 일시정지
			} catch (Exception e) {
		}
			}
			
		for(int i = 0; i < 5; i++) {
				System.out.println("beep!");
				try {
					Thread.sleep(500); // 0.5초간 일시정지
				} catch (Exception e) {
			}
				}
	}
}
