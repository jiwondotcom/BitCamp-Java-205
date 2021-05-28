package ex.informanager;

public class UnivFriend extends Friend {

	// [대학교 친구]는 [전공 정보]를 추가적으로 가진다.
	String major;
	
	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major; // 초기화
	}
	
	@Override // @태그시, 오버라이드 규칙에 맞지않을 경우 알려준다. 
	public void showData() {
		super.showData();
		System.out.println("전   공: " + major);
	}
	
	@Override
	// (!=) The method showBasicInfor() of type UnivFriend must override or implement a supertype method.
	public void showBasicInfo() {
		System.out.println("이   름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("주   소: " + address);

		
		
}
	}	