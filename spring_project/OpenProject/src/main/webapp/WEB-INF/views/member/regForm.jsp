<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file = "/WEB-INF/views/frame/metaheader.jsp" %>
<link rel = "stylesheet" href = "/op/css/default.css">
<script src = "https://code.jquery.com/jquery-1.12.4.min.js"></script>

</head>
<body>

<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>

<div id = "content">
	<h2>회원가입</h2>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form method = "post" enctype = "multipart/form-data"> 

	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type = "text" name = "userID" id = "userID" required>
				<span id = "msg" class = "display_none"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "userPW" minlength = '4' required ></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "userName" required></td>
		</tr>
			<tr>
			<td>사진</td>
			<td><input type = "file" name = "userPhoto"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록" id = "btn">
				<input type = "reset" value = "초기화" id = "btn">
				<input type = "button" value = "이전으로" id = "btn">
			</td>
		</tr>
	</table>
	</form>
</div>


</body>
</html>