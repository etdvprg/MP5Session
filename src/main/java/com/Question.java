package com;
import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String quest;
    private List<String> solutions;
    private int correctSolIndex;
    private Difficulty difficulty;
    
    public Question (String quest, List<String> possibleAnswers, int correctSolIndex, Difficulty difficulty) {
        this.quest = quest;
        this.solutions = possibleAnswers;
        this.correctSolIndex = correctSolIndex;
        this.difficulty = difficulty;
    }

    public String getQuest() {
        return quest;
    }

    public List<String> getPossibleAnswers() {
        return solutions;
    }

    public int getCorrectSolIndex() {
        return correctSolIndex;
    }


    public Difficulty getDifficulty() {
        return difficulty;
    }
    
    public boolean verifyAnswer(int userAnswerIndex) {
        return this.correctSolIndex == userAnswerIndex;
    }
 
}
