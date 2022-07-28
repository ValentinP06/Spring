package com.tp.quiz.api;

import com.tp.quiz.business.Question;
import com.tp.quiz.business.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class QuestionController {
    @Autowired
    QuizService quizService;


    @GetMapping("question")
    public List<Question> getAll() {
return quizService.getAllQuestions();

        /*
        List<Question> json = new ArrayList<>();
        for(Question question: quizService.getAllQuestions()){
            json.add(question);
        }
        return json;
    }

    @PostMapping("question")
    public void createQuestions(@RequestBody Question question){
        quizService.addQuestion(question);
    }


    @PostMapping("question/{questionId}/play/{answerId}")
    public Boolean validateAnswer(@PathVariable("questionId") Long questionId,
                                  @PathVariable("answerId") Long answerId){
    return quizService.validateAnswer(questionId, answerId);
    }



    @GetMapping("question/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable("id") Long id){
        Optional<Question> q = quizService.findQuestion(id);
        if(q.isPresent()){
           Question question = q.get();
            return ResponseEntity.status(HttpStatus.OK).body(question);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }*/
    }

}

