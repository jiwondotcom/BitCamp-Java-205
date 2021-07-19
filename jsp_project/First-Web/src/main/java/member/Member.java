package member;


// 빈즈 클래스 생성
public class Member {

	// 변수는 모두 private 처리
	// 직접적인 접근을 막는다(캡슐화)
	// default - 같은 패키지 / protected - 상속 관계
	private String id;
	private String pw;
	private String name;

	
	// beans 클래스는 기본 생성자 필수
	public Member(){}

	
	// setter
	public void setId(String id) {
		this.id = id;
	}
	
	// getter
	public String getId() {
		return this.id;
	}

	
	// setter
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	// getter
	public String getPw() {
		return this.pw;
	}
	
	
	// setter
	public void name(String name) {
		this.name = name;
	}
	
	// getter
	public String getName() {
		return this.name;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

	
	
}
