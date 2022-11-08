/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Model.Account;
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
public class TestController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account)req.getSession().getAttribute("account");
         resp.getWriter().println(acc.getRole());
         //data
//SELECT * from [Attandance] att 
//INNER JOIN [Session] ses on att.sesid = ses.sesid 
//Inner join [Group] g on ses.gid = g.gid
//Inner Join [Subject] s on g.subid = s.subid
//where att.stdid = 1 and s.subid=1 
    }
    
}
