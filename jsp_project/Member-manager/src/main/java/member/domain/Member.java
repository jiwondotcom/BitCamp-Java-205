package member.domain;

import java.sql.Timestamp;

public class Member {
	
	// Beans 빈즈 형태
	private int index;
	private String userID;
	private String userPW;
	private String userName;
	private Timestamp regDate;
	


	public Member(int index, String userID, String userPW, String userName, Timestamp regDate) {
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



	public Timestamp getRegDate() {
		return regDate;
	}



	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	
	// 로그인 정보에 비밀번호는 노출하지 않는다.
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.index, this.userID, this.userName);
	}
	
	
	// index는 input type = readonly로 설정 예정
	// 아이디, 비밀번호, 이름만 회원정보 수정이 가능하도록 설정한다.
	public EditInfo editInfo() {
		return new EditInfo(this.index, this.userID, this.userPW, this.userName);
	}
	
}
