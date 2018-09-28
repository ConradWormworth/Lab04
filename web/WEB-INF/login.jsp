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
        <form action="" method="post">
            Username: <input type="text" value="${name}">
            <br>
            Password: <input type="password"value="${password}">
            <br>
            <input type="submit" value="Login">
        </form>
        
    </body>
</html>
