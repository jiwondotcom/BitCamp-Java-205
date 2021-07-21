<%@page import="java.sql.DriverManager"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	// 사용자가 전달하는 회원번호 받기 -> 실행 -> 결과
	String index = request.getParameter("index");
	
	int resultCnt = 0;
	
	
	// 전달받은 회원번호로 회원정보를 가져온다.
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. DB 처리
	// 연결
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
		
	// jdbcUrl
	String jdbcUrl = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
	String user = "root";
	String pw = "1234";
		
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	resultCnt = dao.deleteMember(conn, Integer.parseInt(index));
	
	out.println(resultCnt);

	if(resultCnt > 0) {
		%>
		<script>
			alert('삭제되었습니다.');
			location.href = "member_list.jsp";
		</script>
		<%
	} else {
		%>
		<script>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href = "member_list.jsp";
		</script>
		<%
	}



%>