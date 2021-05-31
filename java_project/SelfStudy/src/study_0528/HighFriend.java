package study_0528;

public class HighFriend extends Friend {


	// 고등학교 친구는 직장 정보를 추가로 갖는다.
	String work;
	
	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address); // 상속
		this.work = work;
	}
	
	
	@Override // 메소드읟 동작방법을 덮어써서 변경한다. 
	public void showData() {
		super.showData();
		System.out.println("직업 : " + work);
	}
	
	@Override // Friend 클래스 내의 showBasicInfo() 메소드는 가려지고, 해당 메소드를 사용
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
	}
	
}
