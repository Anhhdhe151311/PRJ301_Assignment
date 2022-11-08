<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : welcomelecturer
    Created on : Nov 8, 2022, 12:14:42 AM
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
        <h1>
            <div style="background-color: brown">${requestScope.account.displayname} |<a href="logout">logout</a></div>
            <h1>Welcome Lecturer</h1>
            <div><a href="lecturer/timetable?lid=1">TimeTable</a></div>
            
        </h1>
    </body>
</html>
