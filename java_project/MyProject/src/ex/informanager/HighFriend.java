package ex.informanager;

public class HighFriend extends Friend {

	// [고등학교 친구]는 [직장 정보]를 추가적으로 갖는다.
	String work;
	
	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work; // 초기화
		
	}

	@Override // @태그시, 오버라이드 규칙에 맞지않을 경우 알려준다. 
	public void showData() {
		super.showData();
		System.out.println("직   업: " + work);
	}

	// Friend 클래스 내의 showBasicInfo() 메소드는 가려지고 해당 메소드로 사용한다.
	@Override
	public void showBasicInfo() {
		System.out.println("이   름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("주   소: " + address);
	
	}

}
