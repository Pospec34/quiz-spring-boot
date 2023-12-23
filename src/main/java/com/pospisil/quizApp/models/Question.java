package com.pospisil.quizApp.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String category;
    private String text;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;


}
