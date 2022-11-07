/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Model.Account;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
        String password = req.getParameter("password");
         
        Account account =new Dal.AccountDAO().get(username, password);
        if(account!=null)
        {
            req.getSession().setAttribute("account", account);
            resp.getWriter().println("login successful!");
        }
        else
        {
            resp.getWriter().println("login failed!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("account/login.jsp").forward(req, resp);
        
    }
    
}
