<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Encoding 필터 처리 예정 -->
<% 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id = "messageRequest" class = "guest.domain.MessageRequest"/>
<jsp:setProperty property = "*" name = "messageRequest"/>

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
	
	${messageRequest}


</body>
</html>