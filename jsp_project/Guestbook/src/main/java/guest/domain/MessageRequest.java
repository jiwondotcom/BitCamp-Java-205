package guest.domain;

public class MessageRequest {
	
	private String guestName;
	private String password;
	private String message;

	
	// getter-setter
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
	

	
	// MessageRequest => Message
	// Message 객체 반환
	public Message toMessage() {
		return new Message(guestName, password, message);
	}
	
	
	// overiding
	@Override
	public String toString() {
		return "MessageRequest [guestName=" + guestName + ", password=" + password + ", message=" + message + "]";
	}
	
	
	
	
	
}
