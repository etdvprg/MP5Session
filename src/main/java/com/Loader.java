package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loader {

public static void saveGameProgress(Player player, Quiz quiz, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(quiz);
        String quizSerialized = Base64.getEncoder().encodeToString(bos.toByteArray());

        String gameProgress = player.getUsername() + "," + player.getScore() + "," + player.isGameStatus() + ","
                + player.getQuestionNumber() + "," + (quiz.getCurrentQuestionIndex() + 1) + "," + quizSerialized;

        Cookie gameProgressCookie = new Cookie("gameProgressCookie", gameProgress);
        gameProgressCookie.setHttpOnly(false);
        gameProgressCookie.setPath("/");
        gameProgressCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(gameProgressCookie);
    }
    
    public static void loadGameProgress(HttpServletRequest request, HttpSession session) throws IOException, ClassNotFoundException {
        Cookie[] loadCookies = request.getCookies();
        if (loadCookies != null) {
            for (Cookie cookie : loadCookies) {
                if (cookie.getName().equals("gameProgressCookie")) {
                    String gameProgress = cookie.getValue();
                    String[] gameStates = gameProgress.split(",");

                    Player player = new Player(gameStates[0], Integer.parseInt(gameStates[1]), Boolean.parseBoolean(gameStates[2]), Integer.parseInt(gameStates[3]), Long.parseLong(gameStates[4]));
                    byte[] quizSerialized = Base64.getDecoder().decode(gameStates[5]);
                    ByteArrayInputStream bis = new ByteArrayInputStream(quizSerialized);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    Quiz quiz = (Quiz) ois.readObject();

                    session.setAttribute("player", player);
                    session.setAttribute("quiz", quiz);
                }
            }
        }
    }
}
