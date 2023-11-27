<%-- 
    Document   : index
    Created on : Nov 24, 2023, 1:39:29 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time-Travel GeoGiggly Quizt</title>
    </head>
    <body>
        <h1>Welcome to Time-Travel GeoGiggly Quizt!</h1>
        <form action="/MP5Session/com/AuthenticationServlet" method="POST">
            <label for="username">Declare forth your Giggly Gamertag:</label> <input type="text" id="username" name="username" required>
            <br>
            <button type="submit">Go!</button>
        </form>
        <br>
        <a href="/gametime/leaderboard.jsp">View Leaderboard</a>
    </body>
</html>

