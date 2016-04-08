<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transactions</title>
</head>


<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

th {
	text-align: left;
}
</style>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h2>Transactions</h2>
    <br>
    <h4>Account ID = <c:out value="${accountid }" /></h4>

	<table style="width: 100%">
		<tr>
			<th>Transaction ID</th>
			<th>Transaction Type</th>
			<th>Amount</th>
			<th>Transaction Date</th>

		</tr>
		<c:forEach var="item" items="${translist}">
			<tr>
				<td><c:out value="${item.transid }" /></td>
				<td><c:out value="${item.transtype }" /></td>
				<td><c:out value="${item.amount }" /></td>
				<td><c:out value="${item.transdate }" /></td>


			</tr>
		</c:forEach>
	</table>

  <h4>Balance = <c:out value="${balance }" /></h4>
  
	<form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>View Product Details</h3>
		To view product details, enter product code. <br />
		<br /> <input type="hidden" name="option" value="2"> 
		<label for="productcode">Enter Product Code:</label> 
			<input id="productcode" name="productcode" value="${param.productcode}">
			 <input type="submit">
		</p>
	</form>

	<form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>See Your Shopping Cart</h3>
		<br /> <input type="hidden" name="option" value="4">  
		<input type="submit" value="Shopping Cart">
		</p>
	</form>



</body>
</html>