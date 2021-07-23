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

	<c:choose>
		<c:when test = "${param.sel == 'a'}">
		<h3>a를 선택했습니다.</h3>
		</c:when>
		
		<c:when test = "${param.sel == 'b'}">
		<h3>b를 선택했습니다.</h3>
		</c:when>
		
		<c:when test = "${param.sel == 'c'}">
		<h3>c를 선택했습니다.</h3>
		</c:when>
		
		<c:otherwise>
		<h3>a, b, c가 아닌 데이터를 선택했습니다.</h3>
		</c:otherwise>
	</c:choose>
	
	
	<c:set var = "num" value = "10"/>
	
	
	
	<c:choose>
		<h3><c:when test = "${num > 0}">양수입니다.</c:when></h3>
		<h3><c:when test = "${num < 0}">음수입니다.</c:when></h3>
		<h3><c:otherwise>0입니다.</c:otherwise></h3>
	</c:choose>
	
	${num}

</body>
</html>