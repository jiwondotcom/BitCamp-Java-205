package guest.domain;

import java.sql.Timestamp;

public class Message {
	
	private int messageID;
	private String guestName;
	private String password;
	private String message;
	private Timestamp regDate;

	
	
	// 같은 이름으로 생성자 3개 overoading
	
	// default 생성자
	public Message() {}

	
	public Message(int messageID, String guestName, String password, String message, Timestamp regDate) {
		this.messageID = messageID;
		this.guestName = guestName;
		this.password = password;
		this.message = message;
		this.regDate = regDate;
	}


	
	// 사용자로부터 받는 데이터
	public Message(String guestName, String password, String message) {
		this.guestName = guestName;
		this.password = password;
		this.message = message;
	}


	
	
	// getter-setter
	public int getMessageID() {
		return messageID;
	}


	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}


	public String getGuestName() {
		return guestName;
	}


	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	
	// toString
	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", guestName=" + guestName + ", password=" + password + ", message="
				+ message + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	
	
}
