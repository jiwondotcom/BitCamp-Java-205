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
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {

	
	// @Autowired
	// MemberDao dao;
	
	@Autowired
	private JdbcTemplateMemberDao dao;
	
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
			
			
			// �쟾�떖諛쏆� ID�� PW濡� DB�뿉�꽌 寃��깋
			// : 議댁옱�븳�떎硫� 濡쒓렇�씤 泥섎━(true return), �뾾�떎硫� false 由ы꽩 泥섎━

			if(member != null) {
				
				// 濡쒓렇�씤 泥섎━
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// �븘�씠�뵒 ���옣�쓣 �쐞�븳 Cookie �꽕�젙 �븘�슂
		if (reID != null && reID.length() > 0) {

			Cookie cookie = new Cookie("reID", reID);

			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 365);
			// 60珥� * 60遺� * 24�떆媛� * 365�씪

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
