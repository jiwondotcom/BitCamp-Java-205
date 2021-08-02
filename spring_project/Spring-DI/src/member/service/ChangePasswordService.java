package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {

	Dao dao;
	
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
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
