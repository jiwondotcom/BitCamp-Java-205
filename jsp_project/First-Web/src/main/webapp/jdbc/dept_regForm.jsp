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

	<h1>부서 정보 등록</h1>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form action = "regDept.jsp" method = "post">
	<table>
		<tr>
			<td>부서번호</td>
			<td><input type = "number" name = "deptno" required></td>
			<td>부서이름</td>
			<td><input type = "text" name = "dname" required></td>
			<td>위치</td>
			<td><input type = "text" name = "loc" required></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록">
				<input type = "reset" value = "초기화">
			</td>
		</tr>
	</table>
	</form>
	











</body>
</html>