package com.bitcamp.op.member.service;

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
	
	
	public Member getMember(int index) {

		dao = template.getMapper(Dao.class);
		// Member member = dao.selectByIndex(index);
		
		return dao.selectByIndex(index);
	}

}
