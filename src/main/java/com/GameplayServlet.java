package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GameplayServlet extends HttpServlet {
    
    /*
    private int score = 0;
    private int questCtr = 0;
    private QuestionBank qBank;
    */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gamertag = request.getParameter("username");
        
        //Store user session
        HttpSession session = request.getSession();
        session.setAttribute("username", gamertag);
        
        if (gamertag != null) {
            response.sendRedirect("/MP5Session/ready.jsp");
        } // should have some mechanisms placed here for null usernames
        
        
        
       /* String answer = request.getParameter("answer");
        String correctAnswer = qBank.getQuestion(request.getParameter("difficulty"), questCtr).getSolutions().get(qBank.getQuestion(request.getParameter("difficulty"), questCtr).getCorrectSolIndex());
    
        if (answer.equals(correctAnswer)) {
            score++;
        }
        
        questCtr++;
        
        if (questCtr < 10 && answer.equals(correctAnswer)) {
            // Move to the next question
            request.setAttribute("score", score);
            request.setAttribute("question", questionBank.getQuestion(request.getParameter("difficulty"), questionNumber));
            request.setAttribute("difficulty", request.getParameter("difficulty"));
            request.getRequestDispatcher("/gameshow.jsp").forward(request, response);
        } else if (questionNumber == 10 && answer.equals(correctAnswer)) {
            // Player has won
            request.setAttribute("score", score);
            response.sendRedirect("/MP5Session/aftermath.jsp");
        } else {
            // Game over
            request.setAttribute("score", score);
            response.sendRedirect("/MP5Session/gameover.jsp");
        }
        */
    }
        
    
}

