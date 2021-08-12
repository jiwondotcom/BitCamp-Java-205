package com.bitcamp.op.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {
	
	// @Autowired
	// MemberDao dao;

	// @Autowired
	// private JdbcTemplateMemberDao dao;
	
	// @Autowired
	// private mybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
 	private Dao dao;
	
 	
	public boolean login(String userID,
						 String userPW,
						 String reID,
						 HttpSession session,
						 HttpServletResponse response) {
		
		boolean loginChk = false;
		
		// Connection conn = null;
		
		// 인터페이스의 Mapper Dao 생성
		dao = template.getMapper(Dao.class);
		
		System.out.println("인터페이스 매퍼 dao 생성 완.");
		
		
			// conn = ConnectionProvider.getConnection();
			Member member = dao.selectByIdPw(userID, userPW);
			
		
			if(member != null) {
				
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk = true;
			}
			
			
		// ID 저장을 위한 쿠키 설정
		// reID 값의 유무 체크
		if (reID != null && reID.length() > 0) {

			Cookie cookie = new Cookie("reID", reID);

			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 365);
			// 60초 * 60분 * 24시간 * 365일

			response.addCookie(cookie);

		} else {

			Cookie cookie = new Cookie("reID", reID);

			cookie.setPath("/");
			cookie.setMaxAge(0);

			response.addCookie(cookie);

		}
		
		
		return loginChk;
	}
	
}
