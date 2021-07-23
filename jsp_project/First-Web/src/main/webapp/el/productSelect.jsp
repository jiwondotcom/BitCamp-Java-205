<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택 페이지</title>
</head>
<style>
</style>
<script>
</script>
<body>


	<h3>
	
	
		1. 선택한 상품 : ${param.select} <br>
		2. 상품의 설명 : ${product.display} <br>
		<!-- display 변수는 없음 -> EL은 메소드를 호출 -->
		3. 첫번째 상품 : ${product.productList[0]}
		
		
	</h3>

</body>
</html>