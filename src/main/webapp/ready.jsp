<%-- 
    Document   : ready
    Created on : Nov 24, 2023, 1:40:32 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Rules!</title>
    </head>
    <body>
        <h1>Mechanics!</h1>
        Here are the mechanics of the quizt!, <%= session.getAttribute("username") %>!
        Mechanics:
            
        <a href="/MP5Session/gameshow.jsp">Start Game</a>
    </body>
</html>