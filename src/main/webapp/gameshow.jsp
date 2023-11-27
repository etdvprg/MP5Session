<%@page import="java.util.List"%>
<%@ page import="com.Quiz, com.Question" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Time!</title>
    </head>
    <body>
        <h1>Here lies the quiz!</h1>

        <h2>Player: ${player.username}! </h2>
        <h2>Score: ${player.score} </h2>


        <%
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            if (quiz != null) {
                Question currentQuestion = quiz.getQuestion();
                if (currentQuestion != null) {
        %>
        <h2>Question:</h2> <p><%= currentQuestion.getQuest()%></p>
        <%
            List<String> possibleAnswers = currentQuestion.getPossibleAnswers();
            for (int i = 0; i < possibleAnswers.size(); i++) {
        %>
        <form action="/MP5Servlet/com/QuizServlet" method="POST">
            <input type="hidden" name="answer" value="<%= i%>">
            <button type="submit"><%= possibleAnswers.get(i)%></button>
        </form>
        <%
                    }
                }
            }
        %>
    </body>
</html>

