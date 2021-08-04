package com.bitcamp.firstSpring.member.controller;

public class LoginRequest {
	
	private String userID;
	private String userPW;
	

	// 기본 생성자 필수

	
	
	// Setter / Getter
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
	

	
	@Override
	public String toString() {
		return "LoginRequest [userID=" + userID + ", userPW=" + userPW + "]";
	}

	
	
}
