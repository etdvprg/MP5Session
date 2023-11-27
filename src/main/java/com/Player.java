package com;
public class Player {

    private String username;
    private int score;
    private long timer;
    private boolean gameStatus;

    public Player(String username) {
        this.username = username;
        this.score = 0;
        this.timer = System.currentTimeMillis();
        this.gameStatus = false;
    }

    public void answerQuestion(String answer, Question question) {
        long elapsedTime = System.currentTimeMillis() - this.timer;

        this.score += 1000 / elapsedTime;
        this.timer = System.currentTimeMillis();

        //if answer is false, then gameStatus = true;
    }
    
    //more methods to come

}
