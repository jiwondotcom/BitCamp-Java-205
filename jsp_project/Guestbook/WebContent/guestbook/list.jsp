<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%

	// 사용자로부터 페이지 번호를 전달 받는다. list.jsp?page=3, list.jsp
	String pageNumStr = request.getParameter("page");
	
	// default 값 먼저 설정 (요청이 들어오지 않을 때 : 첫페이지)
	int pageNum = 1;
	if(pageNumStr != null) {
		pageNum = Integer.parseInt(pageNumStr);
	}
	
	/* if(pageNumStr == null) {
		pageNumStr = "1";
	} */
	
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



</body>
</html>