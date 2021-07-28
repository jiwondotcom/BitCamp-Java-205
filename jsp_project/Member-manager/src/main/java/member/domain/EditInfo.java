package member.domain;

public class EditInfo {

	private int index;
	private String userID;
	private String userPW;
	private String userName;
	private String userPhoto;
	
	
	public int getIndex() {
		return index;
	}
	public String getUserID() {
		return userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	
	
	public EditInfo(int index, String userID, String userPW, String userName, String userPhoto) {
		this.index = index;
		this.userID = userID;
		this.userPW = userPW;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	
	
	@Override
	public String toString() {
		return "EditInfo [index=" + index + ", userID=" + userID + ", userPW=" + userPW + ", userName=" + userName + "]";
	}
	
	
	
	
}
