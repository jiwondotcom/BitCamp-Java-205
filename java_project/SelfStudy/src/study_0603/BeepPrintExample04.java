package study_0603;

public class BeepPrintExample04 {
	public static void main(String[] args) {
		
		Thread thread = new BeepThread();
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Beep!");
			try { 
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
