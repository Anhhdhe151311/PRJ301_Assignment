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
        <div style="background-color: brown"><h1><a href="../view/student/welcomelecturer.jsp">Home</a></h1>${requestScope.account.displayname} |<a href="logout">logout</a></div>
        <h1>Welcome Student</h1>
        <p><a href="student/attreport?stdid=${student.id}">AttendanceReport</a></p>
        <p><a href="student/time?stdid=${student.id}">TimeTable</a></p>
    </body>
</html>
