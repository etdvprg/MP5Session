import java.util.List;

public class Question {
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

    /**
     * @return the quest
     */
    public String getQuest() {
        return quest;
    }

    /**
     * @return the possibleAnswers
     */
    public List<String> getPossibleAnswers() {
        return solutions;
    }

    /**
     * @return the correctSolIndex
     */
    public int getCorrectSolIndex() {
        return correctSolIndex;
    }

    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }
    
    public boolean verifyAnswer(int userAnswerIndex) {
        return this.correctSolIndex == userAnswerIndex;
    }
    
}
