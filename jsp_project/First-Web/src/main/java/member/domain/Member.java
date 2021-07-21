package member.domain;

public class Member {
	
	// Beans 빈즈 형태
	private int Index;
	private String userID;
	private String userPW;
	private String userName;
	private String regDate;
	
	
	// 기본 생성자 생성
	public Member() {}

	

	public Member(int index, String userID, String userPW, String userName, String regDate) {
		this.Index = index;
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.regDate = regDate;
	}




	// getter-setter
	public int getIndex() {
		return Index;
	}


	public void setIndex(int index) {
		Index = index;
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


	
	

	// 변수 일괄 출력 : toString (데이터 확인용)
	@Override
	public String toString() {
		return "Member [Index=" + Index + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName
				+ ", regDate=" + regDate + "]";
	}

	
	
	
}
