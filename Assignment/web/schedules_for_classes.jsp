<%-- 
    Document   : schedules_for_classes
    Created on : Oct 12, 2022, 10:52:33 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div style="text-align:  center">
            <form action="" method="">
                Campus
                <select>
                    <option>FU-HL</option>
                </select></br>
                Lecturer<input type="text" name="txtLecturer"> <input type="submit" value="View">
            </form>
            </div>
        <table id="table">
                <thead >
                <tr>
                    <th rowspan="2">
                        YEAR<select>
                            <option>2021</option>
                            <option>2022</option>
                        </select></br>
                        WEEK<select>
                            <option>10/10 To 16/10</option>
                            <option>17/10 To 23/10</option>
                        </select>
                    </th>
                    <th >Mon</th>
                    <th >Tue</th>
                    <th >Wed</th>
                    <th >Thu</th>
                    <th >Fri</th>
                    <th >Sat</th>
                    <th >Sun</th>
                </tr>

                <tr>
                    <th>09/05</th>
                    <th >10/05</th>
                    <th >11/05</th>
                    <th >12/05</th>
                    <th >13/05</th>
                    <th >14/05</th>
                    <th >15/05</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Slot 1</td>
                    </tr>
                     <tr>
                        <td>Slot 2</td>
                    </tr>
                    <tr>
                        <td>Slot 3</td>
                    </tr>
                    <tr>
                        <td>Slot 4</td>
                    </tr>
                     <tr>
                        <td>Slot 5</td>
                    </tr>
                     <tr>
                        <td>Slot 6</td>
                    </tr>
                     <tr>
                        <td>Slot 7</td>
                    </tr>
                     <tr>
                        <td>Slot 8</td>
                    </tr>
                </tbody>
            </table>
        
        <h1>Campus</h1>
    </body>
</html>