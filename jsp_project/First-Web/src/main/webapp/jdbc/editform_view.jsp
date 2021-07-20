<%@page import="dept.domain.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// object 형변환
    	Dept dept = (Dept) request.getAttribute("dept");
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

	<h1>부서 정보 수정</h1>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<!-- readonly : 읽기 전용 (수정 불가) -->
	<!-- : 부서번호 deptno는 primary key로 수정이 불가능하도록 처리한다. -->
	<form action = "editDept.jsp" method = "post">
	<table>
		<tr>
			<td>부서번호</td>
			<td><input type = "number" name = "deptno"  value = "<%= dept.getDeptno() %>"readonly></td>
		</tr>
		<tr>
			<td>부서이름</td>
			<td><input type = "text" name = "dname" value = "<%= dept.getDname() %>"required></td>
		</tr>
		<tr>	
			<td>위치</td>
			<td><input type = "text" name = "loc" value = "<%= dept.getLoc() %>"required></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록">
				<input type = "reset" value = "초기화">
				<input type = "button" value = "이전으로" onclick = "location.href = 'dept_list.jsp';">
			</td>
		</tr>
	</table>
	</form>


</body>
</html>