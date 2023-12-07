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
    
    public Player(String username, int score, boolean gameStatus, int questionNumber, long timer) {
        this.username = username;
        this.score = score;
        this.gameStatus = gameStatus;
        this.questionNumber = questionNumber;
        this.timer = System.currentTimeMillis();
    }

    public void answerQuestion(int answerIndex, Question question) {
        long elapsedTime = System.currentTimeMillis() - this.getTimer();
        this.timer = System.currentTimeMillis();
        if (answerIndex == question.getCorrectSolIndex()) {
            Difficulty difficulty = question.getDifficulty();
            switch (difficulty) {
                case EASY:
                    this.score += (10000 / (int) elapsedTime) + 3;
                    break;
                case INTERMEDIATE:
                    this.score += (10000 / (int) elapsedTime) + 7;
                    break;
                case DIFFICULT:
                    this.score += (10000 / (int) elapsedTime) + 10;
                    break;
            }
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

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public long getTimer() {
        return timer;
    }
    
    public int getQuestionNumber() {
        return questionNumber;
    }
}
