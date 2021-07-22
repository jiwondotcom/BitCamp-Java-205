package member.domain;

public class Member {
	
	// Beans 빈즈 형태
	private int index;
	private String userID;
	private String userPW;
	private String userName;
	private String regDate;
	
	


	public Member(int index, String userID, String userPW, String userName, String regDate) {
		this.index = index;
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.regDate = regDate;
	}


	
	
	// 기본 생성자 생성
	public Member() {}

	

	// getter-setter
	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getUserPW() {
		return userPW;
	}



	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


}
