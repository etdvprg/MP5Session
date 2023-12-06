package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("sessionCookie")) {
                loadGameProgress(request, session);
            } else {
                response.sendRedirect("MP5Session/index.jsp");
            }
        }
        

        if (session.getAttribute("leaderboard") == null) {
            session.setAttribute("leaderboard", new Leaderboard());
        }

        Player player = (Player) session.getAttribute("player");
        Quiz quiz = (Quiz) session.getAttribute("quiz");

        String answer = request.getParameter("answer");
        Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");

        Question currentQuestion = quiz.getQuestion();
        int userAnswerIndex = Integer.parseInt(answer);

        player.answerQuestion(userAnswerIndex, currentQuestion);
        session.setAttribute("player", player);
        saveGameProgress(player, quiz, response);

        if (currentQuestion.verifyAnswer(userAnswerIndex) == false) {
            leaderboard.addPlayer(player);
            response.sendRedirect("/MP5Session/gameover.jsp");
        } else if (quiz.isQuizComplete()) {
            leaderboard.addPlayer(player);
            response.sendRedirect("/MP5Session/gameon.jsp");
            deleteGameProgress(response);
        } else {
            quiz.nextQuestion();
            response.sendRedirect("/MP5Session/gameshow.jsp");
        } 
    }
    
    private void saveGameProgress(Player player, Quiz quiz, HttpServletResponse response) {
        String gameProgress = player.getUsername() + "," + player.getScore() + "," + player.isGameStatus()
               + player.getQuestionNumber() + "," + quiz.getCurrentQuestionIndex() + quiz.getQuiz();
        Cookie gameProgressCookie = new Cookie ("gameProgress", gameProgress);
        gameProgressCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(gameProgressCookie);
    }
    
    private void loadGameProgress(HttpServletRequest request, HttpSession session) {
        Cookie[] loadCookies = request.getCookies();
        if (loadCookies != null) {
            for (Cookie cookie : loadCookies) {
                String gameProgress = cookie.getValue();
                String[] gameStates = gameProgress.split(":");
                Player player = new Player(gameStates[0], Integer.parseInt(gameStates[1]), Boolean.parseBoolean(gameStates[2]), Integer.parseInt(gameStates[3]), Long.parseLong(gameStates[4]));
//                Quiz quiz = new Quiz(Integer.parseInt(gameStates[5]));
//                session.setAttribute("player", player);
//                session.setAttribute("quiz", quiz);
            }
        }
    }
    
    private void deleteGameProgress(HttpServletResponse response) {
        Cookie gameProgressCookie = new Cookie("gameProgress", "");
        gameProgressCookie.setMaxAge(0);
        response.addCookie(gameProgressCookie);
    }
 
}
