package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {
	
	// @Autowired
	// MemberDao dao;

	// @Autowired
	// private JdbcTemplateMemberDao dao;
	
	@Autowired
	mybatisMemberDao dao;
	
	
	public boolean login(String userID,
						 String userPW,
						 String reID,
						 HttpSession session,
						 HttpServletResponse response) {
		
		boolean loginChk = false;
		
		// Connection conn = null;
		
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
