<%@ page import="java.util.List" %>
<%@ page import="com.Player" %>
<%@ page import="com.Leaderboard" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/MP5Session/css/leaderboard.css">
        <title>Leaderboard</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="leaderboard-form">
                <header class="leaderboard-header">Leaderboard</header>
                <div class="leaderboard-table">
                    <table>
                        <%
                            Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");
                            List<Player> top20Players = leaderboard.getLeaderboardPlayers();
                            boolean authenticated = (Boolean) session.getAttribute("authenticated");
                            for (Player player : top20Players) {
                                if (authenticated) {
                        %>
                        <tr>
                            <td class="name"><%= player.getUsername()%></td>
                            <td class="points_delete"><%= player.getScore()%></td>
                            <td>
                                <form action="/MP5Session/com/LeaderboardServlet" method="post">
                                    <input type="hidden" name="selectedPlayers" value="<%= player.getUsername()%>">
                                    <div class="delete-wrapper">
                                        <input class="go-delete" type="submit" value="Delete <%= player.getUsername()%>">
                                    </div
                                </form>
                            </td>
                        </tr>
                        <%
                        } else {
                        %>
                        <tr>
                            <td class="name"><%= player.getUsername()%></td>
                            <td class="points"><%= player.getScore()%></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                </div>
                <div class="admin-box">
                    <form action="/MP5Session/com/LeaderboardServlet" method="post">
                        <label for="secretUsername">Secret Username:</label><br>
                        <input type="text" id="secretUsername" name="secretUsername"><br>
                        <input type="submit" value="Submit">
                    </form>
                </div>

                <div class="return">
                    <a href="/MP5Session/index.jsp"><button class="go-return">Return to Homepage!</button></a>
                </div>
            </div>
        </div>
    </body>
</html>