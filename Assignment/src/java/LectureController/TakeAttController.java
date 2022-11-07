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
import Dal.*;
import Model.*;

/**
 *
 * @author Admin
 */
public class TakeAttController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Session ses = new Session();
        ses.setId(Integer.parseInt(req.getParameter("sesid")));
        String[] stdids = req.getParameterValues("stdid");
        for (String stdid : stdids) {
            Attandance a = new Attandance();
            Student s = new Student();
            a.setStudent(s);
            a.setSession(ses);
            s.setId(Integer.parseInt(stdid));
            a.setPresent(req.getParameter("present"+stdid).equals("present"));
            a.setDescription(req.getParameter("description"+stdid));
            ses.getAtts().add(a);
        }
        
        
        new SessionDAO().updateAttandance(ses);
        
        resp.sendRedirect("takeatt?id="+ses.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sesid = 1;
        Session ses =new SessionDAO().get(sesid);
        req.setAttribute("ses", ses);
        ArrayList<Attandance> atts =new AttandanceDAO().getAttsBySessionId(sesid);
        req.setAttribute("atts", atts);
        req.getRequestDispatcher("").forward(req, resp);
    }
    
}
