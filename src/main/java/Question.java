import java.util.List;

public class Question {
    private String quest;
    private List<String> solutions;
    private int correctSolIndex;
    private int difficulty;
    
    public Question(String quest, List<String> solutions, int correctSolIndex, int difficulty) {
       this.quest = quest;
       this.solutions = solutions;
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
     * @return the solutions
     */
    public List<String> getSolutions() {
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
    public int getDifficulty() {
        return difficulty;
    }
}
