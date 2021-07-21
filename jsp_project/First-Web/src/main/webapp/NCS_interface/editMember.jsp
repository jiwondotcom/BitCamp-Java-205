<%@page import="member.domain.Member"%>
<%@page import="member.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자가 입력한 데이터를 받은 후
	// 2. DB 처리 : 새로운 데이터 edit(수정)
	// 3. member_list.jsp 페이지로 이동
	
	
	// 0. 사용자가 입력한 데이터의 한글 처리 (우선)
	request.setCharacterEncoding("UTF-8");

	
	// 1. 사용자가 입력한 데이터를 받는다.
	// 비밀번호, 이름
	String userPW = request.getParameter("userpw");
	String userName = request.getParameter("username");
	
	int resultCnt = 0;
	
	
	// 2. DB 처리 : 새로운 데이터를 edit(수정)
	
	// 2-1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2-2. 연결
	Connection conn = null;
	MemberDao dao = null;
	
	conn = ConnectionProvider.getConnection();
	dao = MemberDao.getInstance();
	
	resultCnt = dao.updateMember(conn, new Member(Integer.parseInt(index), userID, userPW, userName, regdate));

	if (resultCnt > 0) {
		%>
		<script>
			alert('수정되었습니다.');
			location.href = "member_list.jsp";
		</script>
		<%
	} else {
		%>
		<script>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href = "editForm_view.jsp";
		</script>
		<%
	}
	
	
	
%>