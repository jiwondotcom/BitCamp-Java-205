<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	${members} <br>
	${members[0]} <br>
	${members[1]} / ${memeber[1].name} / 
	
	
	<c:out value="${memeber[0].name}"/>
	
	/
	
	<c:out value ="${memeber[1].name}" escapeXml = "false">
		<!-- 인라인방식으로 Style속성 부여 -->
		<!-- <c:out value=""/>으로 쓰면 단일행으로 이용할 수 있다 -->
		<span style = "color : blue;">입력된 정보 없음.</span>
	</c:out>

</body>
</html>