package study_0529;

public class phoneUnivInfo extends PhoneAll {

	String major;
	String year;
	
	public phoneUnivInfo(String name, String phoneNumber, String address,
						String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + year);
	}
	
	@Override
	public void showBasicInfo() {

		System.out.println("이름 : " + this.name);
		System.out.println("전화 : " + this.phoneNumber);
		System.out.println("주소 : " + this.address);
		System.out.println("메일 : " + this.email);

	}
}
