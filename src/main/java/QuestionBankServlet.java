import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionBankServlet extends HttpServlet {
    private QuestionBank qBank;
    
    @Override
    public void init() {
        qBank = new QuestionBank();
        
        qBank.addQuestion(new Question("Which country neighbors Kazakhstan to the north?", Arrays.asList("Russia", "Tajikistan", "China", "Mongolia"), 0), "Easy");
        
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String difficulty = request.getParameter("difficulty");
        // int index = getIndex(difficulty);
        //Question q = qBank.getQuestion(difficulty, index);
        response.setContentType("text/plain");
        //response.getWriter().write(q.getQuest());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    /*private int getIndex(String difficulty) {
        switch (difficulty) {
            case "Easy":
                int easyIndex = this.easyIndex;
                this.easyIndex = (this.easyIndex + 1) % 3;
                return easyIndex;
            case "Intermediate":
                int intermediateIndex = this.intermediateIndex;
                this.intermediateIndex = (this.intermediateIndex + 1) % 3;
                return intermediateIndex;
            case "Difficult":
                int difficultIndex = this.difficultIndex;
                this.difficultIndex = (this.difficultIndex + 1) % 4;
                return difficultIndex;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + difficulty);
        }
    }*/

}
