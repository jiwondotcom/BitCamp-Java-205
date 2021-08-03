package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {

	private Dao dao;
	
	// 프로퍼티 방식의 주입 : dao 주입을 위한 setter 메소드를 이용, 기본생성자가 필요하다.
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// 기본생성자 정의
	public ChangePasswordService() {
		System.out.println("ChangePasswordService() 기본 생성자 생성 ");
	}
	
	
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
		System.out.println("ChangePasswordService 인스턴스 생성");
	}
	
	public void changePassword(String email, String oldPW, String newPW) throws Exception {
		
		System.out.println("change : " + email);
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지 않는 회원입니다.");
		}
		
		member.changePassword(oldPW, newPW);
		
		dao.update(member);
		
	}
	
}
