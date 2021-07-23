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

	span {
		color : blue;
		font-weight : bold;
	}

</style>
<script>
</script>
<body>

	<%-- ${members} --%>

	<h1>회원 리스트</h1>
	<hr>
	
	<table border = "1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>index</th>
			<th>count</th>
		</tr>
			
		
		<!-- 반복하고자 하는 아이템 속성을 기재해준다. -->
		<c:forEach items = "${members}" var = "member">
		<tr>
			<td>${member.ID}</td>
			<td>${member.PW}</td>
			<td>
				<c:out value = "${member.name}" escapeXml = "false">
				<span>등록된 정보가 없습니다.</span>
				</c:out>
			</td>
			<td>${stat.index}</td>
			<td>${stat.count}</td>
		</tr>
		</c:forEach>
	</table>
	
	
	<hr>
	<h1> 숫자 5번 반복</h1>
	<!-- 1부터 시작해서 5까지, 1씩 증가 -->
	<c:forEach var = "number" begin = "1" end = "5" step = "1">
		<h3>${number}</h3>
	</c:forEach>
		



</body>
</html>