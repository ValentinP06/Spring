package com.tp.quiz.dao;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Classement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassementRepository extends JpaRepository<Classement,Long>{
}

