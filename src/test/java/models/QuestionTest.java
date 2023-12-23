package models;

import org.junit.jupiter.api.Test;
import com.pospisil.quizApp.models.Question;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    @Test
    void testGetterAndSetter() {
        Question question = new Question();
        question.setQuestionId(1);
        question.setCategory("Test Category");
        question.setText("Test Text");
        question.setCorrectAnswer("Test Correct Answer");
        question.setWrongAnswer1("Test Wrong Answer 1");
        question.setWrongAnswer2("Test Wrong Answer 2");

        assertEquals(1, question.getQuestionId());
        assertEquals("Test Category", question.getCategory());
        assertEquals("Test Text", question.getText());
        assertEquals("Test Correct Answer", question.getCorrectAnswer());
        assertEquals("Test Wrong Answer 1", question.getWrongAnswer1());
        assertEquals("Test Wrong Answer 2", question.getWrongAnswer2());
    }
}