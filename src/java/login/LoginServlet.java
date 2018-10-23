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

        // If the user has just logged out from the Home page...
        if(request.getParameter("logout") != null){
                
            request.setAttribute("loginFailure", "Successfully logged out.");
        }
        
        // Fetch the current session
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String cookieName = "loginCookie";
        String cookieValue = "";
        for (Cookie cookie: cookies) {
            if (cookieName.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                
                request.setAttribute("username", cookieValue);
                request.setAttribute("rememberMe", "on");
             
            }
        }
        
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
            Cookie cookie = new Cookie("loginCookie", username);
            if (request.getParameter("rememberMe") == null) {
                // checkbox not checked
                cookie.setMaxAge(0);
            } else {
                //checkbox checked 
                response.addCookie(cookie);
                session.setAttribute("sessionUsername", username);
            }
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("loginFailure", "Login attempt unsuccessful");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
