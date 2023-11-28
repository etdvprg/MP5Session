<%-- 
    Document   : gameover
    Created on : Nov 24, 2023, 4:02:16 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost!</title>
    </head>
    <body>
        <h1>:o u lost xD</h1>
        <h2>Your score: ${player.score}</h2> <br>

        <h2> View the Leaderboard! </h2> <br>
        <a href="/MP5Session/leaderboard.jsp"><button name="toLeaderboards">Leaderboards</button></a>

        <h2> Return to the homepage! </h2>
        <a href="/MP5Session/index.jsp"><button name="toIndex">Return</button></a>
    </body>
</html>
