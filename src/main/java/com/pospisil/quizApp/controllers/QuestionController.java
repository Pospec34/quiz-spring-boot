package com.pospisil.quizApp.controllers;

import com.pospisil.quizApp.models.Question;
import com.pospisil.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("/byCategory/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/create")
    public void addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionById(@RequestBody Integer id){
        questionService.deleteQuestionById(id);
    }

    @PutMapping("/update")
    public void updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
    }

}
