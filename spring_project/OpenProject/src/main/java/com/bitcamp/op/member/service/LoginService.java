package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {

	@Autowired
	MemberDao dao;
	
	
	public boolean login(String userID,
						 String userPW,
						 String reID,
						 HttpSession session,
						 HttpServletResponse response) {
		
		boolean loginChk = false;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			Member member = dao.selectByIdPw(conn, userID, userPW);
			
			
			// 전달받은 ID와 PW로 DB에서 검색
			// : 존재한다면 로그인 처리(true return), 없다면 false 리턴 처리

			if(member != null) {
				
				// 로그인 처리
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 아이디 저장을 위한 Cookie 설정 필요
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
