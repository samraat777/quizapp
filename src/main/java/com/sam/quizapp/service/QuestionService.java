package com.sam.quizapp.service;

import com.sam.quizapp.Model.QuestionModel;
import com.sam.quizapp.dto.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<QuestionModel>> getAllQuestion() {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<QuestionModel>> getQuestionsByCategory( @PathVariable("category") String category){
       // System.out.println("============CATEGORY===============       " + category);
        try{
            return new ResponseEntity<>(questionRepository.getQuestionByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(QuestionModel question) {
        try{
            questionRepository.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
    }
}
