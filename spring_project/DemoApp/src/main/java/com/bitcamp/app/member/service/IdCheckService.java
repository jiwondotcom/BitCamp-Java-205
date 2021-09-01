package com.bitcamp.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;

@Service
public class IdCheckService {

	// @Autowired
	// MemberDao dao;
	
	// @Autowired
	// JdbcTemplateMemberDao dao;
	
	// @Autowired
	// private mybatisMemberDao dao;
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public String idCheck(String id) {
		
		String result = "Y";
		// Connection conn = null;
		
		// 인터페이스의 Mapper Dao 생성
		dao = template.getMapper(Dao.class);

			// conn = ConnectionProvider.getConnection();
			if(dao.selectByID(id) > 0) {
				result = "N";
			}
		
		return result;

	}
	
	
}
