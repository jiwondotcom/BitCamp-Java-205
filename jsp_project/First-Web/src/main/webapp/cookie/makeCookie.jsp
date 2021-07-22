<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// 쿠키 : 문자열 데이터를 사용자의 브라우징에 저장
    	// 쿠키 생성 -> response.add(c)
    	// Cookie
    	Cookie cookie = new Cookie("cname", "test");
    	//쿠키를 브라우저
    	response.addCookie(cookie);
    	response.addCookie(new Cookie("number", "7"));
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<script>
</script>
<body>
	<h1>쿠키 저장</h1>
</body>
</html>