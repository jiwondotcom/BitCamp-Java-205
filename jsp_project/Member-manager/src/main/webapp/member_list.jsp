<%@page import="member.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.util.JdbcUtil"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// member_list.jsp -> 요청을 받고 처리 -> 결과 데이터를 객체 속성에 저장 -> view 지정
	
	
	// 드라이버 로드 : 서블릿클래스 Loader에서 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	try {
	// jdbcURl
	conn = ConnectionProvider.getConnection();
	
	
	// 결과데이터를 request의 속성에 저장
	// 데이터를 공유 (전달)
	request.setAttribute("result", dao.getMemberList(conn));
	
	} catch(SQLException e) {
		e.printStackTrace();		
	} catch(Exception e) {
		e.printStackTrace();		
	} finally {
		JdbcUtil.close(conn);
	}
	
%>
	<!-- view의 역할만 수행하는 페이지로 이동 -->
	<jsp:forward page = "memberList_view.jsp"/>	
	