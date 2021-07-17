<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    // 사용자가 전달한 데이터의 한글 인코딩 처리
    request.setCharacterEncoding("UTF-8");
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    request.setAttribute("id", id);
    request.setAttribute("pw", pw);

	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NAVER : 로그인 완료</title>
<link rel="stylesheet" href="css/Naver_LoginPage.css">
</head>
<body>

    <!-- 로고 섹션 시작 -->
	<%@ include file="include/logo.jsp" %>
    <!-- 로고 영역 끝 -->
	<h1> 로그인이 완료 되었습니다.</h1>
	
	<!-- 데이터를 처리할 위치로 전송 : input 요소에 *** name 속성 *** 을 반드시 정의해주어야 한다! -->
	
	<table border = "1">
	<tr>
		<td>아이디</td>
		<td><%= id %></td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><%= pw %></td>
	</tr>
	</table>
</body>
</html>