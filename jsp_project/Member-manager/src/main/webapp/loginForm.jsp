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
<link rel = "stylesheet" href = "<%= request.getContextPath() %>css/default.css">
</head>
<style>
</style>
<script>
</script>
<body>

 <%@ inlcude file = /WEB-INF/frame/header.jsp %>
 <%@ inlcude file = /WEB-INF/frame/nav.jsp %>

</body>
</html>