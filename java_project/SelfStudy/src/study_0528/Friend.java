package study_0528;

public class Friend {

	// 이름, 전화번호, 주소 => 기본정보 / 변수 선언
	String name;
	String phoneNumber;
	String address;
	
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public void showData() { // 정보를 보여주는 showData 메소드 정의
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
	}
	
	public void showBasicInfo() {}
	// 상속하여 오버로딩을 하기 위한 용도의 메소드 생성
	
	

}
