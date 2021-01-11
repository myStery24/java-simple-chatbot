package com.oop.bot;

import com.oop.bot.quiz.Question1;
import com.oop.bot.quiz.Question2;
import com.oop.bot.game.RollADice;

import java.util.Scanner;

public class SimpleBot {
    private final static Scanner scanner = new Scanner(System.in);

    /*
     *  Coloured Text
     */
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        greet("Connor", "2020"); // change it as you need
        remindName();
        guessAge();
        count();
        testMood();
        System.out.println(TEXT_YELLOW + "====================================================");
        System.out.println("\t\t\t\tChoose a one of these");
        System.out.println("\t(1)Quiz\t\t(2)Brain Teasers\t(3)Exit");
        System.out.println("====================================================" + TEXT_RESET);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        while (choice != 3) {
            if (choice == 1) {
                System.out.println("Let me test you!!");
                question1();
            }
            if (choice == 2) {
                System.out.println("Let me test you!!");
                question2();
            }
            if (choice != 1 && choice != 2)
                System.out.println("There are only 3 selection!! Please retype");

            System.out.println(TEXT_YELLOW + "====================================================");
            System.out.println("\t\t\t\tWhat's next?");
            System.out.println("(1)Quiz\t\t(2)Brain Teasers\t(3)Exit");
            System.out.println("====================================================" + TEXT_RESET);
            choice = in.nextInt();
        }
        test(); // ask users a multiple choice question
        end(); // display a compliment message
        randomDice(); // roll a dice randomly
        stopRollingDice(); // display a message if users enter any message other than yes or y
    }

    /*
     * Bot's greeting part
     */
    private static void greet(String assistantName, String birthYear) {
        System.out.println(TEXT_PURPLE + "Hello! My name is " + assistantName + "." + TEXT_RESET);
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    /*
     * Bot asks for users' name
     */
    private static void remindName() {
        String name = scanner.nextLine(); // reading a name
        System.out.println("What a great name you have, " + name + "!");
    }

    /*
     * A simple math trick to guess users' age
     */
    private static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Say me remainders of dividing your age by 3, 5 and 7.");
        // reading 3 remainders from the standard input
        int rem3 = scanner.nextInt(); // read first number
        int rem5 = scanner.nextInt(); // read second number
        int rem7 = scanner.nextInt(); // read third number
        int age;
        age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105; // formula
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    /*
     *  Program the bot to count from 0 to any positive number users enter
     */
    private static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        System.out.println("Enter an integer number.");
        int num = scanner.nextInt(); // read a number from the standard input
        // a loop to print out all the numbers starting from 0 until it reaches the input entered by users
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    private static void testMood() {
        System.out.println("How is your mood today? (Good/Bad)");
        String mood = scanner.nextLine();
        while (mood.isEmpty()) {
            mood = scanner.nextLine();
        }
        switch (mood) {
            case ("Good"), ("good") -> System.out.println("I feel good too. Oh, let me test your knowledge!");
            case ("Bad"), ("bad") -> {
                System.out.println("Let me show you something funny.");
                Beautifulwords bw = new Beautifulwords("You are guilty,", "For you have stolen my heart.");
                System.out.println(bw.toString());
                System.out.println("So now, let's test your knowledge.");
            }
            default -> {
                System.out.println("Your selection is not correct, please try again.");
                testMood();
            }
        }
    }

    /*
     * Question 1
     */
    // TODO test this method
    private static void question1() {
        String[] arr = {"What is the color of an orange?", "What is the colour of a banana?",
                "Which country does Eiffel Tower located? (Initial in capital letter)",
                "Which country does Sydney Opera House located? (Initial in capital letter)",
                "Hotpot is from which country? (Initial in capital letter)",
                "Pizza is from which country? (Initial in capital letter)"};
        String[] ans = {"orange", "yellow", "France", "Australia", "China", "Italy"};
        Question1 q = new Question1();

        for (int i = 0; i < arr.length; i++) {
            q.setQuestion(arr[i]);
            q.setAnswer(ans[i]);
            System.out.print("==========================================================================\n\t");
            q.display();
            System.out.print("==========================================================================\n");
            System.out.print("Your answer: ");
            String response = scanner.nextLine();
            // j is not updated inside loop
            for (int j = 0; j < 3; i++) {
                if (!q.checkAnswer(response)) {
                    System.out.println("Please try again!");
                    response = scanner.nextLine();
                    q.checkAnswer(response);
                    //i++;
                }
                if (q.checkAnswer(response)) {
                    System.out.println("Correct!\n");
                    break;
                }
                // Not printing this line if users try the quiz for second time
                if (i == 1) {
                    System.out.println("This is the last chance!");
                }
                if (i == 2) {
                    System.out.println("The answers is " + q.getAnswer());
                    break;
                }
            }

        }
    }

    /*
     * Question 2
     */
    private static void question2() {
        String q1 = """
                There are 26 alphabets. How many alphabet left after 'ET' ran away?
                (a)19\s
                (b)24\s
                (c)21""";
        String q2 = """
                What is full of holes but still holds water?
                (a)Sponge\s
                (b)Net\s
                (c)Sieve""";
        String q3 = """
                What 5 letters becomes shorter when you add 2 letters to it?
                (a)Tall\s
                (b)Big\s
                (c)Short""";
        String q4 = """
                What can travel around the word while staying in a corner?
                (a)Aeroplane\s
                (b)Stamp\s
                (c)Map""";
        String q5 = """
                The more it dries, the wetter it gets. What is it?
                (a)Clothes\s
                (b)Towel\s
                (c)Cap""";
        String q6 = """
                Where can you find a forest without trees, a road without cars and a cities without houses?
                (a)Map\s
                (b)Toy\s
                (c)Dream""";

        Question2[] ques = {new Question2(q1, "c", "ET ran away with UFO." + "\n Hehe..."),
                new Question2(q2, "a", "It has many holes on it and it still sucks water." + "\n I know this one is a bit of classic."),
                new Question2(q3, "c", "We add 2 words which are 'er' we will get a 'shorter' word compare to 'short'." + "\n I know this riddle is lame, don't show me that white eye."),
                new Question2(q4, "b", "We stick it on the corner of envelop and it travels to everywhere." + "\n Oops...It's a bit dumb, no?" + " I have two more to ask you. :P"),
                new Question2(q5, "b", "Towel. Once towel is dried, we use it after bath and it will be wet again."),
                new Question2(q6, "a", "On the map we can't see buildings or tree on that location.")};

        for (Question2 que : ques) {
            System.out.print("===============================================================================================\n");
            que.display();
            String answer = scanner.nextLine();
            while (!que.checkAnswer(answer)) {
                System.out.print("Please try again!\n");
                System.out.print("Your answer: ");
                answer = scanner.nextLine();
                que.checkAnswer(answer);
            }
            que.getexp();
        }
    }

    /*
     *  Multiple-choice quiz
     */
    private static void test() {
        System.out.println("By the way, let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("""
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""");
        int ans = scanner.nextInt();
        /*
         * If and only if the choice is 2, the while loop is exited.
         * Otherwise, keep asking the users to try again.
         */
        while (ans != 2) {
            System.out.println("Please, try again.");
            ans = scanner.nextInt();
        }
    }

    private static void end() {
        System.out.println("Congratulations, you are such a brilliant!\n");
    }

    /*
     * Roll a dice
     */
    private static void randomDice() {
        System.out.println("Why don't we try out some interesting thing?");
        System.out.println("I mean, I just got a new dice and I can roll it.");
        System.out.println("Let me show you!");
        RollADice dice = new RollADice(); // create instance: use 'new' operator and invoke constructor
        dice.roll(); // fields are accessed using: the instance name, '.' operator, and the filed name
    }

    private static void stopRollingDice() {
        System.out.println("No? :(");
        System.out.println(TEXT_PURPLE + "That's fine. See you again, Bye!");
    }
}
