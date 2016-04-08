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
				<td><c:out value="${balance }" /></td></tr>
			
		</c:forEach>
	</table>
	
<h3>Would you like to enter a transaction?</h3>

	<form action="AccountDetails" method="post">
		<p>
			<br />
		<h3>Deposit</h3>
	<%-- 	<input type="number" id="number" name="number" value="${param.number}">  --%>
		
		<br /> 
		<input type="number" id="depamount" name="depamount" value="${depamount}">
		<input type="hidden" name="option" value="deposit"> 
		<input type="submit" value="Deposit">
		</p>
	</form>
	<form action="AccountDetails" method="post">
		<p>
			<br />
		<h3>Withdrawal</h3>
		<br>
		<input type="number" id="withamount" name="withamount" value="${withamount}">
		<br /> <input type="hidden" name="option" value="withdrawal">  
		<input type="submit" value="Withdrawal">
		</p>
	</form>
	
    <form action="AccountDetails" method="post">	
		<input type="hidden" name="option" value="1"> 
		<input type="submit" value="Go back to Account list">
	</form>


</body>
</html>