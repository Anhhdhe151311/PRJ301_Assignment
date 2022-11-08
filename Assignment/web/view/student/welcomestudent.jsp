<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : welcome
    Created on : Nov 8, 2022, 1:05:51 AM
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
        <div style="background-color: brown">${requestScope.account.displayname} |<a href="logout">logout</a></div>
        <h1>Welcome Student</h1>
        <% int count=4 %>
        <P><%=count%></P>
    </body>
</html>
