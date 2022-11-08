<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : attendancerepost
    Created on : Nov 8, 2022, 12:23:48 PM
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
        
        <div>
            <div style="background-color: brown">${requestScope.account.displayname} |<a href="logout">logout</a></div>
        </div>
        
            Id: ${requestScope.student.id}<br>
            Name: ${requestScope.student.name}<br>
            
            <br>
        
<!--        nhận giá trị để tìm kiếm học sinh nào ở lớp nào //gửi luôn giá trin subid để tìm số tiết full-->
        <c:forEach var="a" items="${requestScope.students}">
            <a href="attreport?stdid=${requestScope.student.id}&subid=${a.group.subject.id}&gid=${a.group.id}">${a.group.name}(${a.group.subject.name})<br> </a>
            
        </c:forEach>
        <c:if test="">
        </c:if>   
    </body>
</html>
