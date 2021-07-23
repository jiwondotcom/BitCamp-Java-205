<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품을 선택해주세요.</title>
</head>
<style>
</style>
<script>
</script>
<body>

<!-- scope : 속성을 저장할 수 있다. -->
<jsp:useBean id = "product" class = "product.Product" scope = "session"/>
<!--
1. session 객체의 product 이름의 속성이 있는지 확인
2. 있다 -> 현재 product 이름의 변수에, session 영역에 저장되어 있는 객체를 저장하여 사용
3. 없다 -> product.Product 클래스로 객체 생성, session 영역의 속성에 객체를 저장 (product 이름으로)

product p = session.getAttribute("product")
if(p == null) {
	p = new Product();
	session.setAttribute("product", p)
}
-->

<%--
<%= product %>
<br>
${product}
--%>

	<h1>상품 리스트 : 원하시는 상품을 선택하세요.</h1>
	<form action = "productSelect.jsp" method = "post">
	
		<select name = "select">
		<%
			for(int i = 0; i < product.getProductList().length; i++) {
				out.println("<option>" + product.getProductList()[i] + "</option>");
			}
		%>
		</select>

		<input type = "submit">	
	
	</form>










</body>
</html>