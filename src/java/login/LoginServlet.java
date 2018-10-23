/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import business.User;
import business.userService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Fetch the current session
        HttpSession session = request.getSession();
        // Create a User object from the session,
        //  containing any pre-existing information about the user
       
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");


            userService us = new userService();

            User attemptUser = us.Login(username, password);

            if (attemptUser != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
        }
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("loginFailure", "Login attempt unsuccessful");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
}
