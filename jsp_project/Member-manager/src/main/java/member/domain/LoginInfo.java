package member.domain;

public class LoginInfo {
	
	private int index;
	private String userID;
	private String userName;
	
	
	public int getIndex() {
		return index;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}

	
	public LoginInfo(int index, String userID, String userName) {
		this.index = index;
		this.userID = userID;
		this.userName = userName;
	}
	

	@Override
	public String toString() {
		return "회원 번호 : " + index +
				" / 회원 아이디 : " + userID +
				" / 회원 이름 : " + userName;
	}
	

}
