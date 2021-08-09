package com.bitcamp.op.member.domain;

public class LoginInfo {
	
	private int index;
	private String userID;
	private String userName;
	private String userPhoto;
	
	
	public int getIndex() {
		return index;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	
	
	
	public LoginInfo(int index, String userID, String userName, String userPhoto) {
		this.index = index;
		this.userID = userID;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	
	
	@Override
	public String toString() {
		return "회원정보 [회원번호 : " + index + " / 회원ID : " + userID + " / 회원 이름 : " + userName + " / 회원 사진 : " + userPhoto + "]";
	}
	


}
