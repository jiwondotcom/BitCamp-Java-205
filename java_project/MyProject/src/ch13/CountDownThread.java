package ch13;

public class CountDownThread extends Thread {

	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			if (HighLowGame.chk) {
				return;
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("TIME OVER");
		System.exit(0);
	}

}
