package ex.io;

import java.io.*;

public class ObjectSerializable {
	public static void main(String[] args) {

		// 인스턴스를 저장
		try { 
			
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"));
				
		out.writeObject(new Circle (1, 1, 3.4));
		out.writeObject(new Circle (3, 5, 7.9));
		out.writeObject("HELLO");
		out.close();
		
		System.out.println("인스턴스 저장완료");
		
		
		// 인스턴스 복원
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"));
		
		// 복원 순서는 저장순서에 맞게 복원해야한다.
		Circle c1 = (Circle) in.readObject();
		Circle c2 = (Circle) in.readObject();
		String str = (String) in.readObject();
		
		System.out.println("복원된 인스턴스의 데이터를 출력합니다.");

		
		c1.showData();
		c2.showData();
		System.out.println(str);
		
		
		
		} catch(IOException e ) {
			e.printStackTrace();
		}

}

	class Circle implements Serializable{ 
	// 클래스 Circle은 직렬이 가능하다.
	// implements Serializable : 직렬화 대상임을 의미
	
	int x;
	int y;
	double r;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public void showData() {
		System.out.println("원점 [" + x + ", " + y + ",]");
		System.out.println("반지름  : " + r);
	
		}

	}
}