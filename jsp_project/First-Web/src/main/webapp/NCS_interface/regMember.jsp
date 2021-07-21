<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="member.domain.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

/*
	1. 사용자가 입력한 데이터를 받고 -> 처리 -> 결과를 속성에 저장 -> view 지정
	2. DB 처리 : 새로운 데이터 insert
	3. member_List.jsp 페이지로 이동 (javaScript location)
*/
	

	// 0. 사용자가 입력한 데이터의 한글 처리 (우선순위)
	request.setCharacterEncoding("UTF-8");
	
	
	
	// 1. 사용자가 입력한 데이터를 받는다.
	// 아이디, 비밀번호, 이름, 가입일자
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	String userName = request.getParameter("userName");
	
	SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
    Calendar cal = Calendar.getInstance();

    Date date = cal.getTime();
    String regDate = sdf.format(date);
    // 날짜데이터를 String타입으로 형변환

	
	int resultCnt = 0;
	
	// 2. DB 처리 : 새로운 데이터 insert
	
	// 2-1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2-2. 연결
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	// 2-3. jdbcUrl
	String jdbcUrl = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
	String user = "root";
	String pw = "1234";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	
	resultCnt = dao.insertMember(conn, new Member(userID, userPW, userName, regDate));
	
	
	// 3. member_List.jsp 페이지로 이동 (javaScript location)
	// int resultCnt의 값이 1이 나왔을 때 -> 페이지 이동
	
	
	if (resultCnt > 0) {
		%>
		<script>
			alert('등록되었습니다.');
			location.href = "member_list.jsp";
		</script>
		<%
	} else {
		%>
		<script>
			alert('error : 등록되지 않았습니다. \n 회원등록 페이지로 다시 이동합니다.');
			location.href = "member_regForm.jsp";
			// window.history.go(-1);
			// 이전 페이지로 돌아간다.
		</script>
		<%
	}
	


%>