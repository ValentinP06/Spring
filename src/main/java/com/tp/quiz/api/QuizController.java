package com.tp.quiz.api;

import com.tp.quiz.business.Classement;
import com.tp.quiz.business.Quizz;
import com.tp.quiz.business.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuizController {
@Autowired
Classement classement;
Boolean submitted = false;
@Autowired
QuizService quizService;

    @GetMapping("classement")
    public Classement getClassement() {
        return classement;
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }
    @GetMapping("/quizz")
    public String getquizz( Model model ) {

        model.addAttribute("quizz", quizService.getQuestions());
        return "quizz.html";
    }

    @GetMapping("/affichelesquestions")
    public String getquizq( Model model ) {

        model.addAttribute("quizz", quizService.getQuestions());
        return "affichelesquestions.html";
    }

    @PostMapping("/quizz")
    public String quizz(@RequestParam String username, Model model ) {

        submitted = false;
        classement.setUsername(username);

        Quizz quizz = quizService.getQuestions();
        model.addAttribute("quizz", quizz);

        return "quizz.html";
    }


    @PostMapping("/submit")
    public String submit(@ModelAttribute Quizz quizz, Model model) {
        if(!submitted) {
            classement.setTotalCorrect(quizService.getClassement(quizz));
            quizService.saveScore(classement);
            submitted = true;
        }

        return "classement.html";
    }

    @GetMapping("/score")
    public String score(Model model) {
        List<Classement> classement = quizService.getTopScore();
        model.addAttribute("classement", classement);

        return "score.html";
    }

}
