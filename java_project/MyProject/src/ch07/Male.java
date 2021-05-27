package ch07;

public class Male extends Person{

	public String local;
	
	public Male (String name, int frontSsn, String local) {
		super(name, frontSsn);
		this.local = local;
	}
	
	void maleInfo() {
		super.greeting();
	}
	
	void living() {
		System.out.println("제가 사는 지역은 " + local + "입니다.");
	}


}
