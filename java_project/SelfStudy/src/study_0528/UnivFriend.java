package study_0528;

public class UnivFriend extends Friend {
	
	// 대학교 친구들은 전공 정보를 추가적으로 갖는다.
	String major;

	public UnivFriend(String name, String phoneNum, String address, String major) {
		super(name, phoneNum, address);
		this.major = major;
	}


	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + address);
	}

}
