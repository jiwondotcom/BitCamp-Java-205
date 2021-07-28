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
			
			url : 'data.xml',
			success : function(){
				
				$(data).find('product').each(function(){
					var pname = $(this).find('name').text();
					var price = $(this).find('price').text();
					var html = '<h3>이름 : ' + pname + '| 가격 : ' + price + '</h3>';
					$('body').append(html);
					/* body에 html을 append 한다. */
				});
				
				
			}
			
		});
		
	});
		
	
</script>
<body>


	
</body>
</html>