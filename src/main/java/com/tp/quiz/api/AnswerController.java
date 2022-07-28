package com.tp.quiz.api;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Question;
import com.tp.quiz.business.service.QuizService;
import com.tp.quiz.dao.AnswerRepository;
import com.tp.quiz.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class AnswerController {

    @Autowired
    QuizService quizService;

    @GetMapping("answer")
    public List<Answer> getAll() {

        return quizService.getAllAnswers();
    }

    @PostMapping("answer")
    public void createAnswer(@RequestBody Answer answer){
        quizService.addAnswer(answer);
    }

    @GetMapping("answer/{id}")
    public ResponseEntity<Answer> findAnswerById(@PathVariable("id") Long id){
        Optional<Answer> q = quizService.findAnswerById(id);
        if(q.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(q.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

