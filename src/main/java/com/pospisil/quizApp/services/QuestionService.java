package com.pospisil.quizApp.services;

import com.pospisil.quizApp.models.Question;
import com.pospisil.quizApp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }


}
