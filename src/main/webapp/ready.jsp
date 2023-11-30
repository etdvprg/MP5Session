<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href= "/MP5Session/css/index.css" />
        <title>Ready?</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="log-form">
                <header class="mechanics-header">Mechanics</header>
                    <div class="mechanics-info">
                    Here are the technicalities of the quiz, ${player.username}
                    <ul>
                        <li>
                            There are 10 questions of varying difficulty. 
                        </li>
                        <li>
                            You immediately lose upon selecting the incorrect answer. 
                        </li>
                        <li>
                            Scores are dependent on the time of completion of the game.  
                        </li>
                        <li>
                            The leaderboard works on a first-come first-serve basis, but beatable
                            as long as you wage against the top scores of the previous players. 
                        </li>      
                    </ul>
                    </div>
                <form action="/MP5Session/com/QuizInitServlet" method="POST">
                    <button class="go-start" type="submit">Start Game!</button>
                </form>
            </div>
        </div>
    </body>
</html>