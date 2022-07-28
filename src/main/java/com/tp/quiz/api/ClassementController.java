package com.tp.quiz.api;

import com.tp.quiz.business.Classement;
import com.tp.quiz.business.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ClassementController {
    @Autowired
    QuizService quizService;
/*
    @GetMapping("/classement")
    public List<Classement> getAllClassement() {
        return quizService.getAllClassement();
    }*/

}