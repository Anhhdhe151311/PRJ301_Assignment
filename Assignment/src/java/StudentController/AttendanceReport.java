/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentController;

import Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AttendanceReport extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stdid = Integer.parseInt(req.getParameter("stdid"));
        int gid = Integer.parseInt(req.getParameter("gid"));
        int subid = Integer.parseInt(req.getParameter("subid"));
        Account acc = (Account) req.getSession().getAttribute("account");
        req.setAttribute("account", acc);
        ArrayList<Student> students = new Dal.StudentDAO().getStudentGroup(stdid);
        req.setAttribute("students", students);
        Student student = new Dal.StudentDAO().getAllStudent(stdid);
        req.setAttribute("student", student);
        Subject subject = new Dal.SubjectDAO().getSubject(subid);
        req.setAttribute("subject", subject);

        if (acc.getRole() == 1) {

            ArrayList<Attandance> attandances = new Dal.AttandanceDAO().getCheckAttendance(stdid, gid);
            req.setAttribute("attandances", attandances);
            req.getRequestDispatcher("../view/student/attendancerepost.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("account");
        if (acc.getRole() == 1) {
            int stdid = Integer.parseInt(req.getParameter("stdid"));
            

            req.setAttribute("account", acc);
            ArrayList<Student> students = new Dal.StudentDAO().getStudentGroup(stdid);
            req.setAttribute("students", students);
            Student student = new Dal.StudentDAO().getAllStudent(stdid);
            req.setAttribute("student", student);
            if(req.getParameter("gid")!=null){
            int gid = Integer.parseInt(req.getParameter("gid"));
            ArrayList<Attandance> attandances = new Dal.AttandanceDAO().getCheckAttendance(stdid, gid);
            req.setAttribute("attandances", attandances);
            }
            req.getRequestDispatcher("../view/student/attendancerepost.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }

    }

}
