package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        session.setAttribute("quiz", quiz);
        

        if (currentQuestion.verifyAnswer(userAnswerIndex) == false) {
            leaderboard.addPlayer(player);
            deleteGameProgress(request, response);
            response.sendRedirect("/MP5Session/gameover.jsp");
        } else if (quiz.isQuizComplete()) {
            leaderboard.addPlayer(player);
            deleteGameProgress(request, response);
            response.sendRedirect("/MP5Session/gameon.jsp");
            
        } else {
            quiz.nextQuestion();
            session.setAttribute("player", player);
            session.setAttribute("quiz", quiz);
            saveGameProgress(player, quiz, response);
            response.sendRedirect("/MP5Session/gameshow.jsp");
        }
        
    }

    
    private void saveGameProgress(Player player, Quiz quiz, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(quiz);
        String quizSerialized = Base64.getEncoder().encodeToString(bos.toByteArray());

        String gameProgress = player.getUsername() + "," + player.getScore() + "," + player.isGameStatus() + ","
                + player.getQuestionNumber() + "," + (quiz.getCurrentQuestionIndex()+1) + "," + quizSerialized;

        Cookie gameProgressCookie = new Cookie("gameProgressCookie", gameProgress);
        gameProgressCookie.setHttpOnly(false);
        gameProgressCookie.setPath("/");
        gameProgressCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(gameProgressCookie);
    }

    private void deleteGameProgress(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionCookie") || cookie.getName().equals("gameProgressCookie")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    
                    response.addCookie(cookie);
                    System.out.println("Successfully deleted cookie: " + cookie.getName());
                } else {
                    System.out.println("No cookie detected, cookie unmatched.");
                }
            }
        }
    }
}
