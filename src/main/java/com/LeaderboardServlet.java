package com;

import com.Leaderboard;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LeaderboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("leaderboard") == null) {
            session.setAttribute("leaderboard", new Leaderboard());
        }
        
        response.sendRedirect("/MP5Session/leaderboard.jsp");
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("leaderboard") == null) {
            session.setAttribute("leaderboard", new Leaderboard());
        }

        response.sendRedirect("/MP5Session/leaderboard.jsp");
    } */

}
