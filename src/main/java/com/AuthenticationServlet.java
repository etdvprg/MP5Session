package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");

        if (username != null) {
            Player player = new Player(username);
            session.setAttribute("player", player);
            Cookie sessionCookie = new Cookie("sessionCookie", "user_online: " + player.getUsername());
            sessionCookie.setHttpOnly(false);
            sessionCookie.setPath("/");
            sessionCookie.setMaxAge(60 * 60 * 24);
  
            
            response.addCookie(sessionCookie);
            response.sendRedirect("/MP5Session/ready.jsp");   
        }

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("authenticated", false);
        response.sendRedirect("/MP5Session/leaderboard.jsp");
    }
}
