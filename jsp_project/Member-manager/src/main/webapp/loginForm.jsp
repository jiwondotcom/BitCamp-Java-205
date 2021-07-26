<%@page import="member.util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<% 
	CookieBox cBox = new CookieBox(request);

	String reID = cBox.exists("reID") ? cBox.getValue("reID") : "";
	String checked = cBox.exists("reID") ? "checked" : "";
%>

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

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>
 
 <div class = "contents">
 	<h2>Login</h2>
 	<hr>
 	
 	<form action = "login.jsp" method = "post">
 		<table>
 			<tr>
 				<th>아이디</th>
 				<td><input type = "text" name = "userID" value = "${cookie.reID.value}"></td>
 			</tr>
 			<tr>
 				<th>비밀번호</th>
 				<td><input type = "password" name = "userPW" minlength = '4'></td>
 			</tr>
 			<tr>
 				<th></th>
 				<td><input type = "checkbox" name = "reID" value = "on"
 							<%= checked %>> 아이디 기억하기</td>
 			</tr>
 			<tr>
 				<th></th>
 				<td><input type = "submit" id = "btn" value = "로그인"></td>
 			</tr>
 		</table>
 	</form>
 </div>


</body>
</html>