package com.pospisil.quizApp.repository;


import com.pospisil.quizApp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategoryIgnoreCase(String category);

    Optional<Question> findById(Integer id);
}
