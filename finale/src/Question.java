import java.io.Serializable;

public class Question implements Serializable {
    public String question;
    public String answer;
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnser() {
        return answer;
    }

    public void setAnser(String answer) {
        this.answer = answer;
    }
}
