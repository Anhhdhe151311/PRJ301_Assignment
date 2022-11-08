<%-- 
    Document   : timetable
    Created on : Oct 31, 2022, 12:18:31 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div style="background-color: brown"><h1><a href="../view/lecturer/welcomelecturer.jsp">Home</a></h1>${requestScope.account.displayname} |<a href="../logout">logout</a></div>
        <form action="timetable" method="GET">
            Lecturer: <input type="text"  value="${requestScope.lecturer.name}"/>
            <input type="hidden" name="lid" value="${param.lid}"/>
            From: <input type="date" name="from" value="${requestScope.from}"/>
            To: <input type="date" name="to" value="${requestScope.to}"/>
            <input type="submit" value="View"/> 
        </form>
        <table border="1px">
            <tr>
                <td> </td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>${d}<br/>${helper.getDayNameofWeek(d)}</td>
                    </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="slot">
                <tr>
                    <td>${slot.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${helper.compare(ses.getDate(),d) eq 0 and (ses.timeslot.id eq slot.id)}">
                                    <a href="takeatt?id=${ses.id}">${ses.group.name}-${ses.group.subject.name}</a>
                                    <br/>
                                    ${ses.room.name}<br>
                                    <c:if test="${ses.attanded}">
                                        ( <a style="color: green">Atteanded</a> )
                                    </c:if>
                                    <c:if test="${!ses.attanded}">
                                       ( <a style="color: red">Not Yet</a> )
                                    </c:if>
                                </c:if> 
                                  
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

