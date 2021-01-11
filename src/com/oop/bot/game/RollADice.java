package com.oop.bot.game;

import java.util.Random;
import java.util.Scanner;

public class RollADice {

    String roll = "yes";
    String rollAgain = "";
    int randomNumber;
    private final Random random = new Random();
    private final static Scanner scanner = new Scanner(System.in);

    public RollADice() {
        roll();
    }

    public void roll() {
        while (roll.equals("yes") || rollAgain.equals("yes") || rollAgain.equals("y")) {
            System.out.println("Rolling the dice...");
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 1) {
                for1();
            } else if (randomNumber == 2) {
                for2();
            } else if (randomNumber == 3) {
                for3();
            } else if (randomNumber == 4) {
                for4();
            } else if (randomNumber == 5) {
                for5();
            } else if (randomNumber == 6) {
                for6();
            }
            System.out.println("Wow, doesn't this look amazing? Do you want me to roll again?");
            System.out.println("Say yes or y, and I will roll the dice for you!");
            /*
             * Set the initial roll in line 8 to "no"
             * so that it will listen only to the users' input
             */
            roll = "no";
            rollAgain = scanner.nextLine();

            /*
             * Test the input stored in roll and rollAgain
             */
            // System.out.println(roll);
            // System.out.println(rollAgain);
        }

    }

    public void for1() {
        System.out.println("[-----------]");
        System.out.println("[           ]");
        System.out.println("[     0     ]");
        System.out.println("[           ]");
        System.out.println("[-----------]");
    }

    public void for2() {
        System.out.println("[-----------]");
        System.out.println("[           ]");
        System.out.println("[   0   0   ]");
        System.out.println("[           ]");
        System.out.println("[-----------]");
    }

    public void for3() {
        System.out.println("[-----------]");
        System.out.println("[     0     ]");
        System.out.println("[     0     ]");
        System.out.println("[     0     ]");
        System.out.println("[-----------]");
    }

    public void for4() {
        System.out.println("[-----------]");
        System.out.println("[   0   0   ]");
        System.out.println("[           ]");
        System.out.println("[   0   0   ]");
        System.out.println("[-----------]");
    }

    public static void for5() {
        System.out.println("[-----------]");
        System.out.println("[   0   0   ]");
        System.out.println("[     0     ]");
        System.out.println("[   0   0   ]");
        System.out.println("[-----------]");
    }

    public void for6() {
        System.out.println("[-----------]");
        System.out.println("[   0   0   ]");
        System.out.println("[   0   0   ]");
        System.out.println("[   0   0   ]");
        System.out.println("[-----------]");
    }

    private static void bye() {
        System.out.println("Okay :( So what are we going to do next?"); // Do not change this text
    }
}
