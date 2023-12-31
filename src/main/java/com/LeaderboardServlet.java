package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
        String submittedUsername = request.getParameter("username");

        if (submittedUsername != null && submittedUsername.equals(secretUsername)) {
            // Set the "authenticated" attribute to true
            session.setAttribute("authenticated", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            String selectedPlayer = request.getParameter("selectedPlayers");
            if (selectedPlayer != null) {
                // Delete the player
                Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");
                leaderboard.deletePlayer(selectedPlayer);

                // Forward the request back to the admin.jsp page
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error/AUTHe.jsp");
            }
        }
    }
}
