package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminServlet extends HttpServlet {
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
        dispatcher.forward(request, response);
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
            session.setAttribute("authenticated", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error/AUTHe.jsp");
        }
    }
    
}
