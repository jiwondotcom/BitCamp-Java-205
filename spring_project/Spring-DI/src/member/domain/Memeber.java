package member.domain;

import java.util.Date;

public class Memeber {

	private int id;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	// 생성자 생성
	public Memeber(int id, String email, String password, String name, Date regDate) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	// 비밀번호 변경 메소드
	public void changePassword(String oldPW, String newPW) throws Exception {
		
		if(password.equals(oldPW)) {
			password = newPW;
		} else {
			throw new Exception("비밀번호 불일치!");
		}
		
	}
	
	
	
}
