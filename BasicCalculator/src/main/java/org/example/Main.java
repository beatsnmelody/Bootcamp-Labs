package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the best calculator ever! ...Maybe.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double firstNumber = scanner.nextDouble();

        System.out.println("Now, enter the second number:");
        double secondNumber = scanner.nextDouble();

        System.out.println("""
                Now, choose what you want to do!
                (A)ddition
                (S)ubtraction
                (M)ultiplication
                (D)ivision
                """);

        String operation = scanner.nextLine();

        String addition = "Addition";


        double resultA = firstNumber + secondNumber;

        double resultS = firstNumber - secondNumber;

        double resultM = firstNumber * secondNumber;

        double resultD = firstNumber / secondNumber;

            switch (operation) {
                case :
                    System.out.printf("f% + f%", firstNumber, secondNumber);
                case :
                    System.out.printf("f% - f%", firstNumber, secondNumber);
                case M:
                    System.out.printf("f% * f%", firstNumber, secondNumber);
                case D:
                    System.out.printf("f% / f%", firstNumber, secondNumber);
                default:
                    System.out.println("Now, I can't do anything with that!");
            }

    }
}