<%@page import="member.util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	CookieBox cBox = new CookieBox(request);

	String reID = cBox.exists("reID") ? cBox.getValue("reID") : "";
	String checked = cBox.exists("reID") ? "checked" : "";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "<%= request.getContextPath() %>/css/default.css">
</head>
<style>
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
 				<td><input type = "text" name = "userID" value = "<%= reID %>"></td>
 			</tr>
 			<tr>
 				<th>비밀번호</th>
 				<td><input type = "password" name = "userPW"></td>
 			</tr>
 			<tr>
 				<th>ID</th>
 				<td><input type = "checkbox" name = "reID" value = "on"
 							<%= checked %>>아이디 기억하기</td>
 			</tr>
 			<tr>
 				<th></th>
 				<td><input type = "submit"></td>
 			</tr>
 		</table>
 	</form>
 </div>


</body>
</html>