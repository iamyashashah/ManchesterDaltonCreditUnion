<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="UserServlet" method="post">
    <p>
    
    <label for="username">username:</label>
                <input id="username" name="username" value="${param.username}"><br>
                <label for="username">password:</label>
                <input id="password" name="password" value="${param.password}">
                <input type="hidden" name="click" value="2">
               <br>
                <input type="submit">
                 </p>
    </form>
    <td>
    <a href="index.jsp"> Back </a>
    </td>
</body>
</html>