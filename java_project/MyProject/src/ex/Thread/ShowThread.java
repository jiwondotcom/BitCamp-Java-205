package ex.Thread;

public class ShowThread extends Thread {
	public static void main(String[] args)  {

		String tName;
		
		ShowThread (String name) {
			this.tName = name;
			
		}
	}

	@Override
	public void run() {

		for(int i = 0; i < 100; i++) {
			System.out.println("안녕하세요" + tName + "입니다.");
			
			try {
			sleep(100); // 1000분의 1초
		} catch (InterruptedException e) {
			e.printTrace();
			
		}
	}

}
