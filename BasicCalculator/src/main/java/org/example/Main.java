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
                Addition
                Subtraction
                Multiplication
                Division
                """);

        scanner.nextLine();
        String operation = scanner.nextLine();

            switch (operation) {
                case "Addition":
                    System.out.println(firstNumber + secondNumber);
                    break;
                case "Subtraction":
                    System.out.println(firstNumber - secondNumber);
                    break;
                case "Multiplication":
                    System.out.println(firstNumber * secondNumber);
                    break;
                case "Division":
                    System.out.println(firstNumber / secondNumber);
                    break;
                default:
                    System.out.println("Now, I can't do anything with that!");
                    break;
            }

    }
}