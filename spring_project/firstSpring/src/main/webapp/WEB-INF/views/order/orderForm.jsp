<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>주문 페이지</h1>
	<hr>
	<form method = "post">
		<table border = "1">
		
			<!-- 상품 선택란 -->
			<tr>
				<!-- rowspan : 수직 방향으로 n개 셀을 합쳐준다. -->
				<th rowspan="3">상품-1</th>
				<td>ID</td>
				<td><input type="text" name="orderItems[0].itemId"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="orderItems[0].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[0].remark"></td>
			</tr>


			<tr>
				<th rowspan="3">상품-2</th>
				<td>ID</td>
				<td><input type="text" name="orderItems[1].itemId"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="orderItems[1].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[1].remark"></td>
			</tr>


			<tr>
				<th rowspan="3">상품-3</th>
				<td>ID</td>
				<td><input type="text" name="orderItems[2].itemId"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="orderItems[2].number"></td>
			</tr>
			<tr>
				<td>주의</td>
				<td><input type="text" name="orderItems[2].remark"></td>
			</tr>


			<!-- 주소 입력란 -->
			<tr>
				<th rowspan = "3">주소</th>
				<td>우편번호</td>
				<td><input type = "text" name = "address.zipcode"></td>
			</tr>
			<tr>
				<td>주소1</td>
				<td><input type = "text" name = "address.address1"></td>
			</tr>
			<tr>
				<td>주소2</td>
				<td><input type = "text" name = "address.address2"></td>
			</tr>
			
			
			<tr>
				<td></td>
				<td><input type = "submit"></td>
				<td></td>
			</tr>
			
			
		</table>
	</form>

</body>
</html>


<!--

			1. Controller : 사용자 요청 URL 등록 => view 지정
			2. view 생성
			3.  

-->