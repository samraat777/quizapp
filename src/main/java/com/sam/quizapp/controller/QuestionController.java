package com.sam.quizapp.controller;

import com.sam.quizapp.Model.QuestionModel;
import com.sam.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("question")
@EnableWebMvc
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestion")
    public ResponseEntity<List<QuestionModel>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionModel>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionModel question)
    {
        return questionService.addQuestion(question);
    }
}
