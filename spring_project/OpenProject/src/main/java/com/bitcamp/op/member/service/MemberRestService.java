package com.bitcamp.op.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.domain.Member;

@Service
public class MemberRestService {
	
	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;
	
	// index로 검색한 Member 정보
	public Member getMember(int index) {

		dao = template.getMapper(Dao.class);
		// Member member = dao.selectByIndex(index);
		
		return dao.selectByIndex(index);
	}

	// 모든 Member 정보
	public List<Member> getMembers() {
		dao = template.getMapper(Dao.class);
		return dao.selectAll();
	}

}
