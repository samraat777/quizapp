package com.sam.quizapp.controller;

import com.sam.quizapp.Model.QuestionModel;
import com.sam.quizapp.Model.QuestionWrapper;
import com.sam.quizapp.Model.QuizModel;
import com.sam.quizapp.Model.Response;
import com.sam.quizapp.dto.QuizRepository;
import com.sam.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuizRepository quizRepository;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id,responses);
    }
}
