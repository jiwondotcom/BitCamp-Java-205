package member.domain;

public class LoginInfo {
	
	private int index;
	private String userID;
	private String userName;
	
	
	public int getIndex() {
		return index;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}

	
	public LoginInfo(int index, String userID, String userName) {
		this.index = index;
		this.userID = userID;
		this.userName = userName;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginInfo [index=" + index + ", userID=" + userID + ", userName=" + userName + "]";
	}
	
	
	

}
