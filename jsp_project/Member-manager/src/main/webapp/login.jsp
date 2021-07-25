<%@page import="member.util.CookieBox"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.domain.LoginInfo"%>
<%@page import="member.domain.Member"%>
<%@page import="member.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리
	// 로그인 처리 -> Session 객체에 사용자 정보를 저장
	// reID 확인 후, 값을 받아오면 쿠키 설정
	
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String reID = request.getParameter("reID");
	
	boolean loginChk = false;
	
	Connection conn = null;
	MemberDao dao = null;
	
	if(userID != null && userPW != null && userID.trim().length() > 2 && userPW.trim().length() > 3) {
	
	try {
		
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		Member member = dao.selectByIdPw(conn, userID, userPW);
		
		if(member != null) {
			// 회원의 정보를 Session 객체 저장
			// session.setAttribute("member", member);
			session.setAttribute("loginInfo", member.toLoginInfo());
			loginChk = true;
		} 
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}
	
	
	
	// ID 저장을 위한 쿠키 설정
	// reID 값의 유무 체크
	if(reID != null && reID.equals("on")) {
		// 쿠키 저장 : 사용자의 ID를 저장
		response.addCookie(CookieBox.makeCookie("reID", userID, "/", 60*60*24*365));
	} else {
		// 쿠키값을 저장하지 않는다.
		response.addCookie(CookieBox.makeCookie("reID", userID, "/", 0));
	}
	
	if(loginChk) {
		response.sendRedirect("index.jsp");
	} else {
		%>
		<script>
			alert('아이디 또는 비밀번호가 일치하지 않습니다.');
			history.go(-1); // 이전 페이지로 이동
		</script>	
		<%
	}
	
%>  
  