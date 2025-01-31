package org.example.server.questions;

import jakarta.persistence.*;
import org.hibernate.generator.EventType;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private Answer[] answers;

    @ManyToOne
    private Category category;
    private int numCorrect;
    private int numFailure;

    public Question(String question, Answer[] answer, Category category, int numCorrect, int numFailure) {
        this.question = question;
        this.answers = answer;
        this.category = category;
        this.numCorrect = numCorrect;
        this.numFailure = numFailure;
    }

    public String getCorrectOpction() {
        String correctAnswer="";
        for(Answer answer : answers){
            if(answer.isCorrect()){
                correctAnswer=  answer.getAnswer();
            }
        }
        return correctAnswer;
    }

    public boolean isCorrect(int index){
            return answers[index].getAnswer().equals(getCorrectOpction());
        }
}


