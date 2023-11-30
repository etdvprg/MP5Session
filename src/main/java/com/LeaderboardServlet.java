package com;

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

        // Set the authenticated attribute to false by default
        session.setAttribute("authenticated", false);

        response.sendRedirect("/MP5Session/leaderboard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("leaderboard") == null) {
            session.setAttribute("leaderboard", new Leaderboard());
        }

        String secretUsername = getServletConfig().getInitParameter("admin");
        String submittedUsername = request.getParameter("secretUsername");

        if (submittedUsername != null && submittedUsername.equals(secretUsername)) {
            // Set the authenticated attribute to true
            session.setAttribute("authenticated", true);
            response.sendRedirect("/MP5Session/leaderboard.jsp");
        } else {
            // get the selected player from the request
            String selectedPlayer = request.getParameter("selectedPlayers");
            if (selectedPlayer != null) {
                Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");
                leaderboard.deletePlayer(selectedPlayer);
                response.sendRedirect("/MP5Session/leaderboard.jsp");
            } else {
                response.sendRedirect("/MP5Session/error/AUTHe.jsp");
            }
        }
    } 
}
