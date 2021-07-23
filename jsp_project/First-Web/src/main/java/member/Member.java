package member;

public class Member {
	
	private String ID;
	private String PW;
	private String Name;
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	public Member(String iD, String pW, String name) {
		ID = iD;
		PW = pW;
		Name = name;
	}
	
	
	@Override
	public String toString() {
		return "Member [ID=" + ID + ", PW=" + PW + ", Name=" + Name + "]";
	}

	

	
	
	
}
