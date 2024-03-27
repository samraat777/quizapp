package com.sam.quizapp.service;

import com.sam.quizapp.Model.QuestionModel;
import com.sam.quizapp.Model.QuestionWrapper;
import com.sam.quizapp.Model.QuizModel;
import com.sam.quizapp.Model.Response;
import com.sam.quizapp.dto.QuestionRepository;
import com.sam.quizapp.dto.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<QuestionModel> questions = questionRepository.findRandomQuestionByCategory(category,numQ);
        QuizModel quiz = new QuizModel();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);


        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<QuizModel> quiz =  quizRepository.findById(id);
        List<QuestionModel> questions = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(QuestionModel q : questions)
        {
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestion());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        QuizModel quiz = quizRepository.findById(id).get();
        List<QuestionModel> questions = quiz.getQuestions();
        int right = 0;
        int i =0;
        for(Response response :responses)
        {
           if(response.getQuestionAnswer().equals(questions.get(response.getId()-1).getAnswer()))
               right++;
           //i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
