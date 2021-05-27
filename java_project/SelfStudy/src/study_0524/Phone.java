package study_0524;

public abstract class Phone {
	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("핸드폰 전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("핸드폰을 종료합니다.");
	}

}
