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

<div class = "allWrap">

	<form action ="writeMessage.jsp" method = "post">
	
		<table>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "guestName" required></td>
			</tr>
			<tr>	
				<td>비밀번호</td>
				<td><input type = "password" name = "password" required></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td>
					<textarea name = "mesage" rows = "10" cols = "10" required></textarea>
				</td>
			</tr>	
			<tr>
				<td></td>
				<td><input type = "submit" value = "제출"></td>
			</tr>
		</table>
	</form>


</div>

</body>
</html>