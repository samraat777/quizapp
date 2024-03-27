package com.sam.quizapp.dto;

import com.sam.quizapp.Model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel,Integer> {

    //@Query(value = "select * from QuizApp.questions q where q.category = ?1 " , nativeQuery = true)
    List<QuestionModel> getQuestionByCategory(String category);

    @Query(value = "select * from QuizApp.questions q where q.category = :category order by RAND() limit :numQ " ,nativeQuery = true)
    List<QuestionModel> findRandomQuestionByCategory(String category, int numQ);
}
