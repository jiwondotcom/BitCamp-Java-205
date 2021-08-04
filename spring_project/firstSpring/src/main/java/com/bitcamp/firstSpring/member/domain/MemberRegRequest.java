package com.bitcamp.firstSpring.member.domain;

public class MemberRegRequest {

	private String userID;
	private String userPW;
	private String userName;
	
	

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

	
	

	@Override
	public String toString() {
		return "MemberRegRequest [userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}
	
	
	
}

