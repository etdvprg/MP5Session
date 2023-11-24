import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private List<Question> easyQuestions;
    private List<Question> intermediateQuestions;
    private List<Question> difficultQuestions;
  
    public QuestionBank() {
        easyQuestions = new ArrayList<>();
        intermediateQuestions = new ArrayList<>();
        difficultQuestions = new ArrayList<>();
    }
    
    public void addQuestion(Question question, String difficulty) {
       switch (difficulty) {
           case "Easy":
               easyQuestions.add(question);
               break;
           case "Intermediate":
               intermediateQuestions.add(question);
               break;
           case "Difficult":
               difficultQuestions.add(question);
               break;
       }
   }
    
    public Question getQuestion(String difficulty, int index) {
       switch (difficulty) {
           case "Easy":
               return easyQuestions.get(index);
           case "Intermediate":
               return intermediateQuestions.get(index);
           case "Difficult":
               return difficultQuestions.get(index);
           default:
               return null;
       }
   }
}
