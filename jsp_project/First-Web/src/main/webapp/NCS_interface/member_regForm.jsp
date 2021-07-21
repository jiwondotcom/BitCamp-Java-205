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
<script type="text/javascript">
	window.onload = function() {
		today = new Date();
		console.log("today.toISOString() >>>" + today.toISOString());
		today = today.toISOString().slice(0, 10);
		console.log("today >>>> " + today);
		bir = document.getElementById("todaybirthday");
		bir.value = today;
	}
</script>
<body>

	<h1>회원 정보 등록</h1>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form action = "regMember.jsp" method = "post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "userID" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "userPW" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "userName" required></td>
		</tr>
		<tr>
			<td>가입일시</td>
			<td><input id = "todaybirthday" type = "date" name = "regDate" readonly></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록">
				<input type = "submit" value = "초기화">
				<input type = "submit" value = "이전으로" onclick = "location.href = 'member_list.jsp';">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>