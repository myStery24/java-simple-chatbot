package com.oop.bot.quiz;

public class Question2 extends Question1 {
    //private String choices;
    private String explanation;

    public Question2(String q2, String ans, String exp) {
        setQuestion(q2);
        setAnswer(ans);
        explanation = exp;
    }

    public void display() {
        super.display();
        System.out.println("Enter a, b, c as your answers");
    }

    public void getexp() {
        System.out.println("Yes!!\tBecause: " + explanation);
    }
}
