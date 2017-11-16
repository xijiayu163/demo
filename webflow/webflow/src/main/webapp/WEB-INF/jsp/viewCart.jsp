<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
</head>
<body>
	<!-- 
	flowExecutionUrl ，表示 flow 执行到当前状态时的 URL 。 flowExecutionUrl 的值已经由 Spring Web Flow 2.0 框架的代码进行赋值，
	并放入相应的 model 中供 view 访问。 flowExecutionUrl 的值包含 flow 在执行过程中会为每一状态生成的唯一的 key ，因此不可用其他手段来获取 
	请求参数中 _eventId 的值与清单 shopping.xml中 transition 元素的 on 属性的值是对应的，在接收到_eventId参数后，相应transition会被执行。
	-->
	<h1>View Cart</h1>
	<h2>Items in Your Cart</h2>
	<c:choose>
		<c:when test="${empty cart.items}">
			<p>Your cart is empty.</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="0">
				<tr>
					<th>Item</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Total</th>
				</tr>
				<c:forEach var="item" items="${cart.items}">
					<tr>
						<td>${item.product.description}</td>
						<td>${item.quantity}</td>
						<td>${item.product.price}</td>
						<td>${item.totalPrice}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>TOTAL:</td>
					<td></td>
					<td></td>
					<td>${cart.totalPrice}</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<a href="${flowExecutionUrl}&_eventId=submit">Submit</a>
	<h2>Products for Your Choice</h2>
	<table>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td><a
					href="${flowExecutionUrl}&_eventId=addToCart&productId=${product.id}">[add
						to cart]</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>