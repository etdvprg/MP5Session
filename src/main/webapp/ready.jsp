<%-- 
    Document   : ready
    Created on : Nov 24, 2023, 1:40:32 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ready Page</title>
    </head>
    <body>
        <h1>Mechanics!</h1>
        Here are the mechanics of the quiz, ${player.username}!

        Mechanics:

        <form action="/MP5Session/com/QuizInitServlet" method="POST">
            <input type="submit" value="Start Game">
        </form>
    </body>
</html>