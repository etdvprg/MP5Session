package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizInitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        QuizManager quizManager = (QuizManager) getServletContext().getAttribute("quizManager");
        Quiz quiz = quizManager.createQuiz();

        session.setAttribute("quiz", quiz);

        response.sendRedirect("/gshowd/gameshow.jsp");
    }
}
