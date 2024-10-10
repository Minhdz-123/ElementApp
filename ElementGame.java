package com.mycompany.heloo.hoahoc;

import java.util.Random;
import java.util.Scanner;

public class ElementGame extends ElementLookup {
    public static void main(String[] args) {
        playGame();
    }

    // Phương thức chơi trò chơi
    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int numberOfQuestions = 30;

        System.out.println("WELCOME TO ELEMENT HUNT!");
        System.out.println("you have 30 question, try your best^^");

        for (int i = 0; i < numberOfQuestions; i++) {
            int atomicNumber = random.nextInt(89) + 1; // Từ 1 đến 89
            Element element = elements.get(atomicNumber - 1);
            System.out.print("Question " + (i + 1) + ": Symbol: " + element.getSymbol() + ". Its name is: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(element.getName())) {
                System.out.println("Goodjob, +1 point for you");
                score++;
            } else {
                System.out.println("WRONGGGGG, the answer is: " + element.getName());
            }
        }

        System.out.println("Game Over!!! you have " + score + " point!!!!!!!! " + "congragulation.");
        scanner.close();
    }

    void display1() {
                Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int numberOfQuestions = 30;

        System.out.println("WELCOME TO ELEMENT HUNT!");
        System.out.println("you have 30 question, try your best^^");

        for (int i = 0; i < numberOfQuestions; i++) {
            int atomicNumber = random.nextInt(89) + 1; // Từ 1 đến 89
            Element element = elements.get(atomicNumber - 1);
            System.out.print("Question " + (i + 1) + ": Symbol: " + element.getSymbol() + ". Its name is: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(element.getName())) {
                System.out.println("Goodjob, +1 point for you");
                score++;
            } else {
                System.out.println("WRONGGGGG, the answer is: " + element.getName());
            }
        }

        System.out.println("Game Over!!! you have " + score + " point!!!!!!!! " + "congragulation.");
        scanner.close();
    }

    }


