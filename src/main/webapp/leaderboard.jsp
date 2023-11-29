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
            boolean authenticated = (Boolean) session.getAttribute("authenticated");
            for (Player player : top20Players) {
                if (authenticated) {
        %>
        <table>
            <tr>
                <td>
                    <label for="player_<%= player.getUsername()%>">Username: <%= player.getUsername()%>, Score: <%= player.getScore()%></label>
                </td>
                <td>
                    <form action="/MP5Session/com/LeaderboardServlet" method="post">
                        <input type="hidden" name="selectedPlayers" value="<%= player.getUsername()%>">
                        <input type="submit" value="Delete <%= player.getUsername()%>">
                    </form>
                </td>
            </tr>
        </table>
        <%
        } else {
        %>
        <p>
            <label for="player_<%= player.getUsername()%>">Username: <%= player.getUsername()%>, Score: <%= player.getScore()%></label>
        </p>
        <%
                }
            }
        %>

        <form action="/gshowd/com/LeaderboardServlet" method="post">
            <label for="secretUsername">Secret Username:</label><br>
            <input type="text" id="secretUsername" name="secretUsername"><br>
            <input type="submit" value="Submit">
        </form>

        <a href="/MP5Session/index.jsp"><button type="submit">Return</button></a>

    </body>

</html>