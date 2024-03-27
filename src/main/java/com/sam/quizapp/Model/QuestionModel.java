package com.sam.quizapp.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Table(name = "questions")
@Data
@Entity
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question;
    private String answer;

}
