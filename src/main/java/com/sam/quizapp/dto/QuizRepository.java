package com.sam.quizapp.dto;

import com.sam.quizapp.Model.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface QuizRepository extends JpaRepository<QuizModel,Integer> {

}
