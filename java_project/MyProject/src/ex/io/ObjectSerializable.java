package ex.io;

import java.io.Serializable;

public class ObjectSerializable {
	public static void main(String[] args) {

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