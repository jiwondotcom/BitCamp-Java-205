package member.service;

import member.dao.Dao;
import member.domain.Member;

public class MemberRegService {
	
	// Dao dao = new MemberDao();
	Dao dao;
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	public void regMember(Member member) {
		
		dao.insert(member);
	}

}
