<%@page import="java.util.List"%>
<%@ page import="com.Quiz, com.Question" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Time!</title>
        <link rel="stylesheet" href= "/MP5Session/css/index.css" />
        <link rel="stylesheet" href= "/MP5Session/css/game.css" />
    </head>
    <body>
        <div class="wrapper">
            <div class="quiz-form">
                <div class="player-info">
                    <h2>Player: ${player.username}! </h2>
                    <h2>Score: ${player.score} </h2>
                </div>
                <%
                    Quiz quiz = (Quiz) session.getAttribute("quiz");
                    if (quiz != null) {
                        Question currentQuestion = quiz.getQuestion();
                        if (currentQuestion != null) {
                %>
                
                <div class="quiz-box">
                    <div class="quiz-question">
                        <h2>Question:</h2> <p><%= currentQuestion.getQuest()%></p>
                    </div>
                        <div class="quiz-choices">
                            <%
                                List<String> possibleAnswers = currentQuestion.getPossibleAnswers();
                                for (int i = 0; i < possibleAnswers.size(); i++) {
                            %>
                        <form action="/MP5Session/com/QuizServlet" method="POST">
                            <input type="hidden" name="answer" value="<%= i%>">
                            <button class="go-choices" type="submit"><%= possibleAnswers.get(i)%></button>
                        </form>
 
                            <%
                                        }
                                    }
                                }
                            %>
                        </div>
                </div>
            </div>
        </div>
    </body>
</html>

