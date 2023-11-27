package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        Player player = (Player) session.getAttribute("player");
        String answer = request.getParameter("answer");

        Question currentQuestion = quiz.getQuestion();
        int userAnswerIndex = Integer.parseInt(answer);

        player.answerQuestion(userAnswerIndex, currentQuestion);
        session.setAttribute("player", player);

        if (currentQuestion.verifyAnswer(userAnswerIndex) == false) {
            response.sendRedirect("/MP5Session/gameover.jsp");
        } else if (quiz.isQuizComplete()) {
            response.sendRedirect("/MP5Session/gameon.jsp");
        } else {
            quiz.nextQuestion();
            response.sendRedirect("/MP5Session/gameshow.jsp");
        }
    }
}
