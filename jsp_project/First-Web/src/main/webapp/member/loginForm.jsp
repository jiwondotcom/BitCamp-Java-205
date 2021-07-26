<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h1>LoginForm</h1>
	<hr>
	
	<form action = "Login.jsp"> <!-- /web/member/mypage/mypage.jsp -->
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
				<td><input type = "submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>