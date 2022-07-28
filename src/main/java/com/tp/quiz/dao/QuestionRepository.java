package com.tp.quiz.dao;

import com.tp.quiz.business.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long > {
    public List<Question> findAllByTitle(String title);
}
