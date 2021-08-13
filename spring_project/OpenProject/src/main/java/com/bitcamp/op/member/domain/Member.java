package com.bitcamp.op.member.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
	
	// Beans 빈즈 형태
	private int index;
	private String userID;
	private String userPW;
	private String userName;
	private String userPhoto;
	private Timestamp regDate;

	
	public Member(int index, String userID, String userPW, String userName, String userPhoto, Timestamp regDate) {
		this.index = index;
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Member [index=" + index + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName
				+ ", userPhoto=" + userPhoto + ", regDate=" + regDate + "]";
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

	
	public String getUserPhoto() {
		return userPhoto;
	}


	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}


	public Timestamp getRegDate() {
		return new Timestamp(regDate.getTime()-(1000*60*60*9));
	}



	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	
	// java.sql.TimeStamp -> java.util.Date
	public Date getDate() {
		return new Date(getRegDate().getTime());
	}
	
	
	// 로그인 정보에 비밀번호는 노출하지 않는다.
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.index, this.userID, this.userName, this.userPhoto);
	}
	

}
