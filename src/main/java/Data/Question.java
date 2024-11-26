package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private int id;
    private String questionText;
    private String correctAnswer;
    private List<String> wrongAnswers;
    private String element;

    public Question(int id, String questionText, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String element) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = new ArrayList<>(Arrays.asList(wrongAnswer1, wrongAnswer2, wrongAnswer3));
        this.element = element;
    }

    // Các getter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers; // Trả về danh sách các câu trả lời sai
    }

    public String getElement() {
        return element;
    }
}
