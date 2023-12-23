package com.pospisil.quizApp.service;

import com.pospisil.quizApp.models.Question;
import com.pospisil.quizApp.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void QuestionServiceCreatesAQuestion(){
        Question question = Question.builder()
                .questionId(1)
                .category("Category")
                .text("Text")
                .correctAnswer("Correct Answer")
                .wrongAnswer1("Wrong Answer")
                .wrongAnswer2("Wrong Answer 2").build();

        questionService.addQuestion(question);

        verify(questionRepository, times(1)).save(eq(question));

    }




}