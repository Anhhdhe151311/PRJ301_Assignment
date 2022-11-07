<%-- 
    Document   : login
    Created on : Nov 6, 2022, 11:56:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            username: <input type="text" name="username" /> <br/>
            password: <input type="password" name="password" /> <br/>
            <input type="submit" value="Login" /> 
        </form>
    </body>
</html>
