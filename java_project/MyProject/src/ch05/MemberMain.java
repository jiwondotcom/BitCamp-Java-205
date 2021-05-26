package ch05;

public class MemberMain {

	public static void main(String[] args) {
		Member member1 = new Member(
				"짱구",
				"010-1234-5678",
				"음악",
				3, 
				"goo.cannotdry@gmail.com",
				"2015-10-11",
				"부천");
		
//		member1.name="짱구";
		member1.setName("짱구");
		member1.showInfo();
		System.out.println(member1.getName());
		
	}

}