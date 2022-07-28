package com.tp.quiz.business.service;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Classement;
import com.tp.quiz.business.Question;
import com.tp.quiz.business.Quizz;
import com.tp.quiz.dao.AnswerRepository;
import com.tp.quiz.dao.ClassementRepository;
import com.tp.quiz.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    Question question;
    @Autowired
    Classement classement;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    ClassementRepository classementRepository;
    @Autowired
    Quizz quizz;


    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
/*
    public void addQuestion(Question question){
        for (Answer answer : question.getAnswers()){
            answer.setQuestion(question);
        }
        questionRepository.save(question);

    }*/


        public boolean validateAnswer (Long questionId, Long answerId){
        Optional <Answer> answerOptional = answerRepository.findById(answerId);
        if(answerOptional.isPresent()){

            Answer answer = answerOptional.get();
            if(answer.getQuestion().getId().equals(questionId)){
                return answer.isCorrectAnswer();
            }
        }
        return false;
    }


    public Optional<Question> findQuestion(Long id){
        return questionRepository.findById(id);
    }

    /*******************************************************************************/

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public Optional<Answer> findAnswerById(Long id) {
        return answerRepository.findById(id);
    }
/*********************************************************************************/
// le classement des joueurs

/*
    public List<Classement> getAllClassement(){
        return classementRepository.findAll();
    }

    public  List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }*/
/****************************************************************************************************/
public Quizz getQuestions() {
    List<Question> allQuestion = questionRepository.findAll();
    List<Question> questionsList = new ArrayList<>();

    Random random = new Random();

    for(int i=0; i<5; i++) {
        int rand = random.nextInt(allQuestion.size());
        questionsList.add(allQuestion.get(rand));
        allQuestion.remove(rand);
    }

    quizz.setQuestions(questionsList);

    return quizz;
}



public int getClassement(Quizz quizz) {
    int correct = 0;

    for(Question question: quizz.getQuestions())
        if(question.getAns() == question.getChose())
            correct++;

    return correct;
}


    public void saveScore(Classement classement) {
        Classement Classement = new Classement();
        Classement.setUsername(classement.getUsername());
        Classement.setTotalCorrect(classement.getTotalCorrect());
        classementRepository.save(Classement);
    }



    public List<Classement> getTopScore() {
        List<Classement> topList = classementRepository.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return topList;
    }
}
