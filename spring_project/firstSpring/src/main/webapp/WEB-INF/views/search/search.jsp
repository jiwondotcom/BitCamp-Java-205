<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>검색</h1>
	<h3>
		최근 관심 검색어 :
		
		<c:forEach items ="${queryList}" var = "query">
		${query}
		</c:forEach>
	</h3>
	
	
	<select>
		<!-- var : 구분할 수 있는 식별자 -->
		<c:forEach items = "${searchTypeList}" var = "type"> 
		<option value = "${type.value}"> ${type.label} </option>
		</c:forEach>
	</select>
	<!-- input의 기본형 : test -->
	<input> <input type = "submit">
	

</body>
</html>