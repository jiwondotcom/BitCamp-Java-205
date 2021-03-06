package com.bitcamp.op.member.dao;

import java.util.List;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchType;

public interface Dao {

	// 로그인
	Member selectByIdPw(String id, String pw);
	// 아이디 체크
	int selectByID(String userID);
	// 회원가입
	int insertMember(Member member);
	// 회원정보 수정
	int updateMember(Member member);
	// 회원정보 삭제(탈퇴)
	int deleteMember(int index);
	// 회원 전체 리스트
	List<Member> selectAll();
	// 페이징 처리가 가능한 리스트
	List<Member> selectList(int startRow, int count); // (0,3)
	// 전체 회원의 수
	int selectTotalCount();
	// 검색을 통한 회원 리스트
	List<Member> selectMember(SearchType searchType);
	
	// Rest get : idx값으로 Membr 객체를 반환
	Member selectByIndex(int index);
	
	
}
