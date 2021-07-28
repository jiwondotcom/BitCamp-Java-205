<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<style>
</style>
<script>


	$(document).ready(function() {
		// alert("ready");

		$.ajax({
			url : 'parameter.jsp',
			type : 'get', // http method get, post, put, delete
			data : {
				pname : 
			}, // 문자열 형식 ?name=test&prcie=1000, 객체 형식으로 {}
			success : function(data) {
				$('body').html(data);
			}
		});

	});
	
	
</script>
<body>
	
</body>
</html>