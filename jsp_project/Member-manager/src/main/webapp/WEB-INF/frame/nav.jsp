<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Object loginObj = session.getAttribute("loginInfo");
%>

	<nav>
		<ul>
			<% if(loginObj == null) { %>
			<li><a href = "<%= request.getContextPath() %>/member_regForm.jsp">회원가입</a></li>
			<li><a href = "<%= request.getContextPath() %>/loginForm.jsp">로그인</a></li>
			<% } else { %>
			<li><a href = "<%= request.getContextPath() %>/member_regForm.jsp">로그아웃</a></li>
			<li><a href = "<%= request.getContextPath() %>/memberList_view.jsp">회원리스트</a></li>
			<% } %>
			<li><a href = "<%= request.getContextPath() %>/myPage.jsp">MyPage</a></li>
		</ul>
	</nav>