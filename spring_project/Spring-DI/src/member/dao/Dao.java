package member.dao;

import java.util.List;

import member.domain.Member;

public interface Dao {

	// 회원 데이터를 email로 검색 -> Member 객체 반환
	Member selectByEmail(String email);

	
	// 데이터 저장
	void insert(Member member);
	
	// Update(데이터 수정)
	void update(Member member);
	
	// 전체 데이터 출력
	List<Member> selectAll();

}
