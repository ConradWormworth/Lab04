<%-- 
    Document   : login
    Created on : Sep 28, 2018, 3:11:19 PM
    Author     : 612944
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RememberMe?</title>
    </head>
    <body>
        <h1>RememberMe Login Page</h1>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="${username}">
            <br>
            Password: <input type="password" name="password" value="${password}">
            <br>
            <input type="submit" value="login">
            <input type="checkbox" name="rememberMe" value="${rememberMe}">
            <label for="rememberMe">Remember Me</label> <br>
        </form>

        ${loginFailure}
    </body>
</html>
