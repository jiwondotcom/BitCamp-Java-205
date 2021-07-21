<%@page import="jdbc.util.ConnectionProvider2"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="member.domain.Member"%>
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
	String index = request.getParameter("index");
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	String regDate = request.getParameter("regDate");

	int resultCnt = 0;
	
	
	// 2. DB 처리 : 새로운 데이터를 edit(수정)
	
	// 2-1. 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2-2. 연결
	
	Connection conn = null;
	MemberDao dao = null;
	
	try {
		conn = ConnectionProvider2.getConnection();
		dao = MemberDao.getInstance();
	
		resultCnt = dao.updateMember(conn, new Member(Integer.parseInt(index), userID, userPW, userName, regDate));
	
	} catch(SQLException e) {
		e.printStackTrace();
	} finally { 
		JdbcUtil.close(conn);
	}
	
	
	// 3. member_List.jsp 페이지로 이동 (javaScript location)
	// int resultCnt의 값이 1이 나왔을 때 -> 페이지 이동
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
			location.href = "member_list.jsp";
		</script>
		<%
	}
	
	
	
%>