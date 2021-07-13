package object;

public class Member {
	private int MemberCode;
	private String ID;
	private String PW;
	private String mName;
	private int age;
	private String phoneNum;
	private String email;
	
	
	@Override
	public String toString() {
		return "Member [MemberCode=" + MemberCode + ", ID=" + ID + ", PW=" + PW + ", mName=" + mName + ", age=" + age
				+ ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}
	
	
	public int getMemberCode() {
		return MemberCode;
	}
	public void setMemberCode(int memberCode) {
		MemberCode = memberCode;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
