<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>
#btn {
	padding : 5px;
}
</style>
<script>
</script>
<body>

 <div class = "contents">
 	<h2>Login Form</h2>
 	<hr>
 	
 	<!-- <form action = "login.jsp" method = "post"> -->
 	<form method = "post">
 	<!-- action = "/contextPath/member/login" -->
 	<!-- /web/member/mypage/mypage.jsp -->
 		<table>
 			<tr>
 				<td>아이디</td>
 				<td><input type = "text" name = "userID"></td>
 			</tr>
 			<tr>
 				<td>비밀번호</td>
 				<td><input type = "password" name = "userPW"></td>
 			</tr>
 			<tr>
 				<td></td>
 				<td><input type = "submit" id = "btn" value = "로그인"></td>
 			</tr>
 		</table>
 	</form>
 </div>


</body>
</html>