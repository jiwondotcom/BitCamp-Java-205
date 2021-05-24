package ch01;

public class Person {

		String name; // 이름
		String phoneNum; // 연락처
		String ssn; // 주민등록번호
		
		Person(String name, String phoneNum, String ssn) {
			this.name = name;
			this.phoneNum = phoneNum;
			this.ssn = ssn;
	}
		
	public static void main(String[] args) {
		
		Person p1 = new Person("지원","010-1234-5678","111111-1111111");
	
		System.out.println("회원 이름:"+p1.name);
		System.out.println("회원 연락처: "+p1.phoneNum);
		System.out.println("회원 주민번호: "+p1.ssn);
		
		System.out.println();
		
		Person p2 = new Person("짱구","010-5678-1234","2222222222222");
		
		System.out.println("회원이름: "+ p2.name);
		System.out.println("회원 전화번호: "+p2.phoneNum);
		System.out.println("회원 주민번호: "+p2.ssn);

	}
}
