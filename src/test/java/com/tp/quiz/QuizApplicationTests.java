package com.tp.quiz;

import com.tp.quiz.business.Answer;
import com.tp.quiz.business.Question;
import com.tp.quiz.business.service.QuizService;
import com.tp.quiz.dao.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuizApplicationTests {

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionRepository questionRepository;
/*
	@Test
	void testAddQuestion() {

		Question question = new Question();
		question.setTitle("tu t'appelles comment");
		quizService.addQuestion(question);

		Assertions.assertEquals(1, quizService.getAllQuestions().size());
	}

	@Test
	void testCreateQuestionCascadeMode(){
	Question question = new Question("qui ?");
	Answer answer1 = new Answer("moi", false);
	Answer answer2 = new Answer("moi moi", true);
	question.getAnswers().add(answer1);
	question.addAnswer(answer1);

	questionRepository.save(question);
	}*/
}