package com.pospisil.quizApp.service;

import com.pospisil.quizApp.models.Question;
import com.pospisil.quizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findAllByCategoryIgnoreCase(category);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void deleteQuestionById(Integer id){
        questionRepository.deleteById(id);
    }

    public void updateQuestion(Question question){
        questionRepository.save(question);
    }

}
