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
        <link rel="stylesheet" href= "/MP5Session/css/aftermath.css" />
        <title>Lost!</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="aftermath-box">
                <div class="aftermath-info">
                    <div class="aftermath-msg">
                        <h1>Gameover!</h1>
                        <br> 
                    </div>
                    <div class="aftermath-score">
                        <h2>Your score: ${player.score}</h2>
                    </div>
                </div>
                   
                <div class="leaderboards">
                    <form action="/MP5Session/com/LeaderboardServlet" method="GET">
                        <button class="go-leaderboard" type="submit">Leaderboard</button>
                    </form>
                </div>
                    <br>
                    <div class="return">
                        <a href="/MP5Session/index.jsp"><button class="go-return">Return to Homepage!</button></a>
                    </div>
            </div>
        </div>
    </body>
</html>
