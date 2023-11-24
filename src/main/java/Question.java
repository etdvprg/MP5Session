import java.util.List;

public class Question {
    private String quest;
    private List<String> solutions;
    private int correctSolIndex;
    
    public Question(String quest, List<String> solutions, int correctSolIndex) {
       this.quest = quest;
       this.solutions = solutions;
       this.correctSolIndex = correctSolIndex;
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
}
