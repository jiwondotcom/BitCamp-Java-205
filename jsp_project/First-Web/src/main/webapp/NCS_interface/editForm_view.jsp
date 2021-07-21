<%@page import="member.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	// object 형변환
    	Member memebr = (Member) request.getAttribute("member");
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

	<h1>회원 정보 수정</h1>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<!-- readonly : 읽기 전용 (수정 불가) -->
	<form action = "editMember.jsp" method = "post">
	<table>
		
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userID" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" required></td>
		</tr>
		<tr>
			<td><input type = "text" name = "regDate"></td>
			<td><input type = "number" name = "index"></td>
		</tr>

		

		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "수정">
				<input type = "reset" value = "초기화">
				<input type = "button" value = "이전으로" onclick = "location.href='member_list.jsp';">
			</td>
		</tr>
		
	</table>
		
		
	</form>


</body>
</html>