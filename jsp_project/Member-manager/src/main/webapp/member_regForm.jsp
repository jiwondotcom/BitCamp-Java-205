<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>
</style>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

	<h2>회원 정보 등록</h2>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form action = "regMember.jsp" method = "post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "userID" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "userPW" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "userName" required></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록">
				<input type = "reset" value = "초기화">
				<input type = "button" value = "이전으로" onclick = "location.href = 'member_list.jsp';">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>