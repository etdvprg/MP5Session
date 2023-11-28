package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
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

        // Initialize the Leaderboard object if it's not already initialized
        if (session.getAttribute("leaderboard") == null) {
            session.setAttribute("leaderboard", new Leaderboard());
        }

        Quiz quiz = (Quiz) session.getAttribute("quiz");
        Player player = (Player) session.getAttribute("player");
        String answer = request.getParameter("answer");
        Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");

        Question currentQuestion = quiz.getQuestion();
        int userAnswerIndex = Integer.parseInt(answer);

        player.answerQuestion(userAnswerIndex, currentQuestion);
        session.setAttribute("player", player);

        if (currentQuestion.verifyAnswer(userAnswerIndex) == false) {
            leaderboard.addPlayer(player);
            response.sendRedirect("/MP5Session/gameover.jsp");
        } else if (quiz.isQuizComplete()) {
            leaderboard.addPlayer(player);
            response.sendRedirect("/MP5Session/gameon.jsp");
        } else {
            quiz.nextQuestion();
            response.sendRedirect("/MP5Session/gameshow.jsp");
        }
    }
}
