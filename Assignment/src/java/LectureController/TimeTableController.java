/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectureController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import util.DateTimeHelper;
import Model.*;
import Dal.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TimeTableController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
             Account acc = (Account)req.getSession().getAttribute("account");
             
            if (acc.getRole() == 2) {
                int lid = Integer.parseInt(req.getParameter("lid"));
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

                ArrayList<Session> sessions = new SessionDAO().filter(lid, from, to);
                req.setAttribute("sessions", sessions);

                Lecturer lecturer = new LecturerDAO().getIdNameLecturer(lid);
                req.setAttribute("lecturer", lecturer);
                
                req.setAttribute("account", acc);
            } else {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }

            req.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(TimeTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
