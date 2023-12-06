package com;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    public List<Question> questions;
    private int currentQuestionIndex;
    
    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
    }
    
    public Question getQuestion() {
        return questions.get(getCurrentQuestionIndex());
    }
    
    public boolean isQuizComplete() {
        return getCurrentQuestionIndex() == questions.size() - 1; 
    }
    
    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }
    
    public List<Question> getQuiz() {
        return questions;
    }

}
