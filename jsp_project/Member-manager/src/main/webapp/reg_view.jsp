<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<c:if test = "${result ==1}">
	<script>
		alert('등록되었습니다.');
		location.href = '<c:url value = "/index.jsp"/>';
	</script>
</c:if>


<c:if test = "${result == 0}">
	<script>
		alert('error : 등록되지 않았습니다. \n회원등록 페이지로 다시 이동합니다.');
		// 이전 페이지로 돌아간다.
		window.history.go(-1);
		/* location.href = "member_regForm.jsp"; */
	</script>
</c:if>