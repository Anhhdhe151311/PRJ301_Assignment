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

        <table border="1">
            <tr><th>No</th><th>Date</th><th>Slot</th>
                <th>Room</th><th>Lecturer</th><th>Group Name</th>
                <th>Attedance status</th><th>Lecturer's comment</th></tr>
                    <% int no = 1; %>


            <c:forEach var="a" items="${requestScope.attandances}">
                <tr>
                    <td>
                        <%=no%> <%no++;%>
                    </td>
                    <td>
                        ${a.session.date}
                    </td>
                    <td>
                        ${a.session.timeslot.description}
                    </td>
                    <td>
                        ${a.session.room.name}
                    </td>
                    <td>
                        ${a.session.lecturer.name}
                    </td>
                    <td>
                        ${a.session.group.name}
                    </td>
   
                    <td>
                        ${a.present}
                    </td>
                    <td>
                        ${a.description}
                    </td>
                </tr>
            </c:forEach>



        </table>


    </body>
</html>
