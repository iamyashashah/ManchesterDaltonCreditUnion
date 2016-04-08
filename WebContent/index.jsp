<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Dalton Bank User login Page</title>
</head>
<body>
<h2>Welcome to Manchester Dalton Credit Union</h2>
    <form action="UserServlet" method="post">
        <p>
            <label for="username">username:</label>
                <input id="username" name="username" value="${param.username}"><br>
                <label for="username">password:</label>
                <input id="password" name="password" value="${param.password}">
                <input type="hidden" name="click" value="1">
               <br>
                <input type="submit">
        </p>
    </form>
</body>
</html>