<%@page import="dept.domain.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<Dept> list = (List<Dept>) request.getAttribute("result");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

	td, th {
	text-align : center;
	padding : 5px 10px;
	}
	
	button {
	margin : 5px 15px;
	}
	
</style>
<script>
</script>
<body>

<h1>부서 리스트</h1>
<hr>

<button onclick = "location.href = 'dept_regForm.jsp';">부서정보 등록</button>


<table border = 1>
	<tr> 
		<th>부서번호</th>
		<th>부서이름</th>
		<th>위치</th>
		<th>관리</th>
		<!-- <th> : 표의 라벨링 기능 -->
	</tr>
	
	<%
		if(list != null) { 
			for(int i = 0; i < list.size(); i++) { // 배열이 아니므로, length가 아닌 size 사용
				%>
			<tr>
				<td><%= list.get(i).getDeptno() %></td>
				<td><%= list.get(i).getDname()  %></td>
				<td><%= list.get(i).getLoc() %></td>
				<td>
					<a href = "dept_editForm.jsp?deptno=<%= list.get(i).getDeptno() %>">수정</a> | 
					<a href = "javascript:delDept(<%= list.get(i).getDeptno() %>)">삭제</a>
					<!-- 자바스크립트 함수 호출 -->				
				</td>
			</tr>
				<%
			} 
		}
	%>

</table>
</body>
<script>

	function delDept(deptno) {
		
		if(confirm('정말 삭제하시겠습니까?')) {
			location.href = 'dept_deleteForm.jsp?deptno=' + deptno;
		}
	}

</script>

<%-- <% out.println(list); %> --%>


</html>