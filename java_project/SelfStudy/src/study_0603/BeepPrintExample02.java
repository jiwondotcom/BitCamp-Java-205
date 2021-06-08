package study_0603;

public class BeepPrintExample02 {
	public static void main(String[] args) {
		
		Runnable beeptask = new BeepTask();
		Thread thread = new Thread(beeptask);
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("beep!");
			try {
				Thread.sleep(500); 
			} catch (Exception e) {
			}
				}
		}	

	}


