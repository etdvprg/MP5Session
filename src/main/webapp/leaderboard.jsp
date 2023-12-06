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
                            for (Player player : top20Players) {
                        %>
                        <div class="tr-wrap">
                            <tr>
                                <td class="name">
                                    <%= player.getUsername()%>
                                </td>
                                <td class="points_delete">
                                    <%= player.getScore()%>
                                </td>
                            </tr>
                        </div>
                        <%
                            }
                        %>
                    </table>
                </div>
                
                <div class="leaderboard-buttons">
                    <div class="go-btn">
                        <div class="admin">
                            <form action="/MP5Session/com/AdminServlet" method="GET">
                                <button class="go-admin" type="submit">Admin!</button>
                            </form>
                        </div>
                    </div>

                    <div class="go-btn">
                        <div class="return">
                            <a href="/MP5Session/index.jsp"><button class="go-return">Return to Homepage!</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>