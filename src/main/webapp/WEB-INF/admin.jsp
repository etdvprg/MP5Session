<%@ page import="java.util.List" %>
<%@ page import="com.Player" %>
<%@ page import="com.Leaderboard" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="/MP5Session/css/admin.css">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        <div class="wrapper">
            <%
                boolean authenticated = (Boolean) session.getAttribute("authenticated");
                if (authenticated) {
            %>
            <div class="admin-table">
                <table>
                    <tr>
                        <th>Username</th>
                        <th>Score</th>
                    </tr>
                    <%
                        Leaderboard leaderboard = (Leaderboard) session.getAttribute("leaderboard");
                        List<Player> top20Players = leaderboard.getLeaderboardPlayers();
                        for (Player player : top20Players) {
                    %>
                    <tr>
                        <td><%= player.getUsername()%></td>
                        <td><%= player.getScore()%></td>
                        <td>
                            <form action="/MP5Session/com/LeaderboardServlet" method="POST">
                                <input type="hidden" name="selectedPlayers" value="<%= player.getUsername()%>">
                                <input class="go-delete" type="submit" value="" onclick="return confirm('Are you sure you want to delete <%= player.getUsername()%>?')">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
                
                <div class="admin-out">
                    <form action="/MP5Session/com/AuthenticationServlet" method="GET">
                        <button class="go-admin" type="submit">Log-out!</button>
                    </form>
                </div>
                
            <%
            } else {
            %>
            <div class="login-form">
                
                <form action="/MP5Session/com/AdminServlet" method="POST">
                    <label for="username">Username:</label><br>
                    <input type="text" id="username" name="username"><br>
                    <input class="admin-in" type="submit" value="Login">
                </form>
                <br>
                <a href="/MP5Session/leaderboard.jsp"><button class="go-return">Return</button></a>
                
            </div>
                        
            <%
                }
            %>
            </div>
    </body>
</html>