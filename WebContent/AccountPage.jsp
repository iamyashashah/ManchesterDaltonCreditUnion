<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Account Page</title>
</head>
<body>
<form action="AccountServlet" method="post">

<table style="width: 100%">
         
      <p>
        <c:forEach var="item" items="${accountlist}">
            <tr>
                <td><c:out value="${item.Accountid}" /></td>
                <td><c:out input type="radio" value="${item.Accounttype }" /></td>
            </tr>
        </c:forEach>
        <input type="hidden" name="click" value="${item.Accountid}">
               <br>
                <input type="submit">
                </p>  
                
    </table>
    
    </form> 
    <br>
    <br>
    <br>
    <br>
    <br>
    <form action="AccountServlet" method="post">
   
    <p>add new account</p>
     <p>
    <label for="checking">Checking</label>
    <input type="radio" name="Account" id= "checking" value="checking">
            <BR>
            <label for="saving">Saving</label>
            <INPUT type="radio" name="Account" id= "saving" value="saving">
            <BR>
           <input type="hidden" name="click" value="1">
               <br>
                <input type="submit">
                 </p> 
            
    </form>
     <br>
    <br>
    <br>
    
<form action="AccountServlet" method="post">
    
    <p>close existing account</p>
    <p>
    <label for="AccountId">AccountId:</label>
                <input id="AccountId" name="AccountId" value="${param.AccountId}"><br>
           <input type="hidden" name="click" value="2">
               <br>
                <input type="submit" name="closeAccount">
                 </p> 
            
    </form>
</body>
</html>