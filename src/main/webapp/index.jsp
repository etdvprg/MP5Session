<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href= "/MP5Session/css/index.css" />
        <title>Past and Maps Quizt!</title>
    </head>
    <body>
        <div class="wrapper">
            <header class="header"><h1>Past and Maps Quizt!</h1></header>
            <div class="log-form">
                <div class="enter-game">
                    <form action="/MP5Session/com/AuthenticationServlet" method="POST">
                        <label for="username">Declare forth your Gamertag</label>
                        <br>
                        <input type="text" class ="input-username" id="username" name="username" required>
                        <br>
                        <button class="go-game" type="submit">Go!</button>
                    </form>
                        <br>
                </div>
                <div class="leaderboards">
                    <form action="/MP5Session/com/LeaderboardServlet" method="GET">
                        <button class="go-leaderboard" type="submit">Leaderboard</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

