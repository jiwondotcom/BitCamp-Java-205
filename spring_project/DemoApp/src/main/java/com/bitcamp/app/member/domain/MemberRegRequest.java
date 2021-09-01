package com.bitcamp.app.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	private String userID;
	private String userPW;
	private String userName;
	private MultipartFile userPhoto;
	

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

	public MultipartFile getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(MultipartFile userPhoto) {
		this.userPhoto = userPhoto;
	}

	
	
	
	@Override
	public String toString() {
		return "MemberRegRequest [userID=" + userID + ", userPW=" + userPW + ", userName="
				+ userName + ", userPhoto=" + userPhoto.getOriginalFilename() + "]";
	}
	
	
	
	// MemberRegRequest -> Member
	public Member toMember() {
		return new Member(0,
						  userID,
						  userPW,
						  userName,
						  null,
						  null);
	}
	
	
}
