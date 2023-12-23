package com.pospisil.quizApp.repository;


import com.pospisil.quizApp.models.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void QuestionRepositoryReturnsAllQuestions(){
        Question question = Question.builder()
                .questionId(1)
                .category("Category")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();
        Question question2 = Question.builder()
                .questionId(2)
                .category("Category")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();

        questionRepository.save(question);
        questionRepository.save(question2);

        List<Question> questions = questionRepository.findAll();

        Assertions.assertThat(questions).isNotNull();
        Assertions.assertThat(questions.size() == 2);
    }

    @Test
    public void QuestionRepositoryReturnsQuestionsByCategory(){
        Question question = Question.builder()
                .questionId(1)
                .category("OCR")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();
        Question question2 = Question.builder()
                .questionId(2)
                .category("LotR")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();
        Question question3 = Question.builder()
                .questionId(3)
                .category("LotR")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();

        questionRepository.save(question);
        questionRepository.save(question2);
        questionRepository.save(question3);

        List<Question> questions = questionRepository.findAllByCategoryIgnoreCase("lotR");
        List<Question> anotherQuestions = questionRepository.findAllByCategoryIgnoreCase("OCR");

        Assertions.assertThat(questions).isNotNull();
        Assertions.assertThat(anotherQuestions).isNotNull();

        Assertions.assertThat(questions.size() == 2);
        Assertions.assertThat(anotherQuestions.size() == 1);
    }

    @Test
    public void QuestionRepositoryFindsQuestionById() {
        Question question = Question.builder()
                .questionId(1)
                .category("Category")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();

        questionRepository.save(question);

        Question testQuestion = questionRepository.findById(question.getQuestionId()).get();

        Assertions.assertThat(testQuestion).isNotNull();
    }

    @Test
    public void QuestionRepositoryDeletesQuestionById(){
        Question question = Question.builder()
                .questionId(1)
                .category("Category")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();

        questionRepository.save(question);

        questionRepository.deleteById(question.getQuestionId());
        Optional<Question> questionReturn = questionRepository.findById(question.getQuestionId());

        Assertions.assertThat(questionReturn).isEmpty();
    }
}