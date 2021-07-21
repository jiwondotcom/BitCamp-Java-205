package member.domain;

public class Member {
	
	// Beans 빈즈 형태
	private String userID;
	private String userPW;
	private String userName;
	private String regDate;
	
	
	
	public Member(String userID, String userPW, String userName, String regDate) {
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.regDate = regDate;
	}



	// 기본 생성자 생성
	public Member() {}
	
	

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



	// 변수 일괄 출력 : toString (데이터 확인용)
	@Override
	public String toString() {
		return "Member [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + ", regDate=" + regDate
				+ "]";
	}



	

}