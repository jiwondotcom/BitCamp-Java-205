package ex.Thread;

import javax.swing.JOptionPane;

public class ThreadEx1 {
	
	public static boolean chk = false;

	public static void main(String[] args) {
	CountDownThread ct = new CountDownThread();
	inputThread it = new inputThread();
	
	it.start();
	ct.start();
	
}
	}
		
class inputThread extends Thread {
	
	public void run() {
	String name = JOptionPane.showInputDialog("이름을 입력해주세요");
	ThreadEx1.chk = true;
	System.out.println("안녕하세요." + name + "님");

	}
}


class CountDownThread extends Thread {

	@Override
	public void run() {
		for(int i = 10; i > 0; i--) { // 증감 연산
			System.out.println(i);
			try {
				sleep(1000); // 1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}