package com;

public class Player {

    private String username;
    private int score;
    private long timer;
    private boolean gameStatus;
    private int questionNumber;

    public Player(String username) {
        this.username = username;
        this.score = 0;
        this.timer = System.currentTimeMillis();
        this.gameStatus = true;
        this.questionNumber = 0;
    }

    public void answerQuestion(int answerIndex, Question question) {
        long elapsedTime = System.currentTimeMillis() - this.timer;
        this.timer = System.currentTimeMillis();

        if (answerIndex == question.getCorrectSolIndex()) {
            this.score += 10000 / elapsedTime;
            this.questionNumber++;
        } else {
            this.gameStatus = false;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

}
