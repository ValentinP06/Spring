package com.tp.quiz.business;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String optionA;
    private String optionB;
    private int ans;
    private int chose;

    //@OneToMany(mappedBy="question", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    //private List<Answer> answers = new ArrayList<>();


    public Question() {
        super();
    }

    public Question(Long id, String title, String optionA, String optionB, int ans, int chose) {
        super();
        this.id = id;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.ans = ans;
        this.chose = chose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /* public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        answer.setQuestion(this);
        answers.add(answer);
    }*/

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getChose() {
        return chose;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", ans=" + ans +
                ", chose=" + chose +
                '}';
    }
}