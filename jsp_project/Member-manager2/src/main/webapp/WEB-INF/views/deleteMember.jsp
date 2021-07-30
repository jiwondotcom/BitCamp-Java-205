<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>

<c:if test = "${result == 1}">
	<script>
			alert('정상적으로 탈퇴처리되었습니다.');
			session.invalidate();
	</script>
	<script>
			location.href = "index.jsp";
	</script>
</c:if>

 
<c:if test = "${result == 0}">
	<script>
			alert('해당 데이터를 찾지 못했습니다. \n다시 시도해주세요.');
			location.href = "index.jsp";
		</script>
</c:if>

</head>
</html>


