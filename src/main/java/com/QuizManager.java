package com;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizManager {
    private List<Question> allQuestions;
    private List<Question> easyQuestions;
    private List<Question> intermediateQuestions;
    private List<Question> difficultQuestions;

    public QuizManager() {
        this.allQuestions = new ArrayList<>();
        this.easyQuestions = new ArrayList<>();
        this.intermediateQuestions = new ArrayList<>();
        this.difficultQuestions = new ArrayList<>();
    }

    public void addQuestion(String quest, List<String> possibleAnswers, int correctSolIndex, Difficulty difficulty) {
        Question question = new Question(quest, possibleAnswers, correctSolIndex, difficulty);
        allQuestions.add(question);
        sortQuestion(question);
    }
    
    public void sortQuestion(Question question) {
        switch (question.getDifficulty()) {
            case EASY:
                easyQuestions.add(question);
                break;
            case INTERMEDIATE:
                intermediateQuestions.add(question);
                break;
            case DIFFICULT:
                difficultQuestions.add(question);
                break;
        }
    }

        public Quiz createQuiz() {
        List<Question> randomizedQuestionSet = new ArrayList<Question>();

        Collections.shuffle(easyQuestions);
        Collections.shuffle(intermediateQuestions);
        Collections.shuffle(difficultQuestions);

        if (easyQuestions.size() >= 3) {
            randomizedQuestionSet.addAll(easyQuestions.subList(0, 3));
        }
        if (intermediateQuestions.size() >= 3) {
            randomizedQuestionSet.addAll(intermediateQuestions.subList(0, 3));
        }
        if (difficultQuestions.size() >= 4) {
            randomizedQuestionSet.addAll(difficultQuestions.subList(0, 4));
        }
        return new Quiz(randomizedQuestionSet);
    }
}
