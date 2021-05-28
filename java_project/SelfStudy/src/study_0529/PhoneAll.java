package study_0529;

public class PhoneAll {

	String name;
	String phoneNumber;
	String address;
	String email;
	
	public PhoneAll (String name, String PhoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	public void showData() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화 : " + this.phoneNumber);
		System.out.println("주소 : " + this.address);
		System.out.println("메일 : " + this.email);
	}

	public void showBasicInfo() {}

}
