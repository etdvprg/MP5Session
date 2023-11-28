<%@ page import="java.util.List" %>
<%@ page import="com.Player" %>
<%@ page import="com.Leaderboard" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leaderboard</title>
    </head>

    <body>
        <h1>Leaderboard</h1>

        <%
            Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");
            List<Player> top20Players = leaderboard.getLeaderboardPlayers();
            for (Player player : top20Players) {
        %>
        <p>Username: <%= player.getUsername()%>, Score: <%= player.getScore()%></p>
        <%
            }
        %>
    </body>

</html>