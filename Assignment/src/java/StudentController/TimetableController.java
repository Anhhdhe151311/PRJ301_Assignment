/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentController;

import Dal.*;
import Dal.SessionDAO;
import Dal.TimeSlotDAO;
import LectureController.TimeTableController;
import Model.*;
import Model.Lecturer;
import Model.Session;
import Model.TimeSlot;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateTimeHelper;

/**
 *
 * @author Admin
 */
public class TimetableController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account)req.getSession().getAttribute("account");
        if (acc.getRole() == 1) {
            int stdid = Integer.parseInt(req.getParameter("stdid"));
            String raw_from = req.getParameter("from");
            String raw_to = req.getParameter("to");
            java.sql.Date from = null;
            java.sql.Date to = null;
            if (raw_from == null || raw_from.length() == 0) {
                Date today = new Date();
                int todayOfWeek = DateTimeHelper.getDayofWeek(today);
                Date e_from = DateTimeHelper.addDays(today, 2 - todayOfWeek);
                Date e_to = DateTimeHelper.addDays(today, 8 - todayOfWeek);
                from = DateTimeHelper.toDateSql(e_from);
                to = DateTimeHelper.toDateSql(e_to);
            } else {
                from = java.sql.Date.valueOf(raw_from);
                to = java.sql.Date.valueOf(raw_to);
            }
            req.setAttribute("from", from);
            req.setAttribute("to", to);
            req.setAttribute("dates", DateTimeHelper.getDateList(from, to));
            
            ArrayList<TimeSlot> slots = new TimeSlotDAO().list();
            req.setAttribute("slots", slots);
            
            ArrayList<Session> sessions = new SessionDAO().filterStudent(stdid, from, to);
            req.setAttribute("sessions", sessions);
            
            Student student = new StudentDAO().getAllStudent(stdid);
            req.setAttribute("student", student);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
        req.getRequestDispatcher("../view/student/timetable.jsp").forward(req, resp);
    }
    
}
