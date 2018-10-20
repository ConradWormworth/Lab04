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
            Username: <input type="text" name="username">
            <br>
            Password: <input type="password" name="username">
            <br>
            <input type="submit" value="Login">
        </form>
        <input type="checkbox" id="RememberMe" name="rememberMe">
        <label for="RememberMe">Remember Me</label> <br>
        ${loginFailure}
    </body>
</html>
