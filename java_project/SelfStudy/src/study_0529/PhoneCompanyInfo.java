package study_0529;

public class PhoneCompanyInfo extends PhoneAll{

	String company;
	
	public PhoneCompanyInfo (String name, String phoneNumber, String address,
							String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("직장 : " + company);
	}
	
	@Override
	public void showBasicInfo() {
		System.out.println("이   름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("주   소: " + address);

	}
}
