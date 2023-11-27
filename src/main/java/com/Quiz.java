package com;
import java.util.List;

public class Quiz {
    public List<Question> questions;
    private int currentQuestionIndex;
    
    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
    }
    
    public Question getQuestion() {
        return questions.get(currentQuestionIndex);
    }
    
    public boolean isQuizComplete() {
        return currentQuestionIndex > questions.size(); //could be 9 if hard-coded
    }
    
    public void nextQuestion() {
        currentQuestionIndex++;
    }
}
