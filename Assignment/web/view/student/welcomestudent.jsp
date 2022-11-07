<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : welcom
    Created on : Nov 8, 2022, 12:13:30 AM
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
        <h1>Welcome Student</h1>
        <c:if test="${requestScope.account!=null}">
            <p>${account.displayname}</p>
        </c:if>
    </body>
</html>
