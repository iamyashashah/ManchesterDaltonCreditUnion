<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Information</title>
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
	<h2>Account Details</h2>

	<table style="width: 100%">
		<tr>
	<%--		<th>Product Code</th>--%>
	<%-- 		<th>Product Name</th>  --%>

		</tr>
		
		
		
		<c:forEach var="item" items="${accountdetails}">
		      
			<tr>
			    <td>Account ID</td>
			    <td><c:out value="${item.accountid }" /></td></tr>
			    
			    
			<tr>
			    <td>Account Type</td>
				<td><c:out value="${item.accounttype }" /></td></tr>
            <tr> 
                <td>Balance</td>
				<td><c:out value="${item.description }" /></td></tr>
			<tr>	
				<td>Product Price</td>
				<td><c:out value="${item.price }" /></td>
			</tr>
		</c:forEach>
	</table>


	<form action="samazonservlet" method="post">
		<p>
			<br />
		<h3>Interested?</h3>
	<%-- 	<input type="number" id="number" name="number" value="${param.number}">  --%>
		
		<br /> <input type="hidden" id="productcode" name="cartproductcode" value="${cartproductcode}"> 
		<input type="hidden" name="option" value="3"> 
		<input type="submit" value="Add to shopping cart">
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
	
    <form action="samazonservlet" method="post">	
		<input type="hidden" name="option" value="1"> 
		<input type="submit" value="Go back to product list">
	</form>


</body>
</html>