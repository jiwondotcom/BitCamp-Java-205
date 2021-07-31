<%@page import="member.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 : 내정보 수정</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>
</style>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

<div class = "allWrap">
	<h2>회원 정보 수정</h2>
	<hr>
	 
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<!-- readonly : 읽기 전용 (수정 불가) -->
	<form action = "editMember.do" method = "post">
	<div class = "float_left">
	<table>
		<tr>
			<td>회원번호</td>
			<td><input type="number" name="index" value = "${member.index}" readonly></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userID" value = "${member.userID}" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW" value = "${member.userPW}" minlength = '4'></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" value = "${member.userName}"></td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<input type = "submit" id = "btn" value = "수정">
				<input type = "reset" id = "btn" value = "초기화">
				<input type = "button" id = "btn" value = "이전으로" onclick = "location.href='mypage.do';">
			</td>
		</tr>
	</table>
	</div>
	</form>

</div>
</body>
</html>