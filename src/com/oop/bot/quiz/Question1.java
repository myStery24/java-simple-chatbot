package com.oop.bot.quiz;

public class Question1 {
    private String question;
    private String answer;
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RESET = "\u001B[0m";

    public Question1() {
        question = "";
        answer = "";
    }

    public void setQuestion(String questionText) {
        question = questionText;
    }

    public void setAnswer(String ans) {

        answer = ans;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkAnswer(String response) {
        return response.equals(answer);
    }

    public void display() {
        System.out.println(TEXT_PURPLE + question + TEXT_RESET);
    }
}
