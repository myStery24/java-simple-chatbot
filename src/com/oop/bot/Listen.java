package com.oop.bot;

public class Listen {
    private final String sentences;

    public Listen(String sentences) {
        this.sentences = sentences;
    }

    public String toString() {
        return ("" + sentences);
    }
}

class Beautifulwords extends Listen {
    public String Secondsentences;

    public Beautifulwords(String sentences, String Startsentences) {
        super(sentences);
        Secondsentences = Startsentences;
    }

    @Override
    public String toString() {
        return (super.toString() + "\n" + Secondsentences);
    }
}