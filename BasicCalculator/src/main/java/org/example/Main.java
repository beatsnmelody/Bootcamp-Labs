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
                    double sum = addTwoNumbers(firstNumber, secondNumber);
                    System.out.println("The sum is: " + sum);
                    break;
                case "Subtraction":
                    double difference = subtractTwoNumbers(firstNumber, secondNumber);
                    System.out.println("The difference is: " + difference);
                    break;
                case "Multiplication":
                    double product = multiplyTwoNumbers(firstNumber, secondNumber);
                    System.out.println("The product is: " + product);
                    break;
                case "Division":
                    double quotient = divideTwoNumbers(firstNumber, secondNumber);
                    System.out.println("The quotient is: " + quotient);
                    break;
                default:
                    System.out.println("Now, I can't do anything with that!");
                    break;
            }

    }

    public static double addTwoNumbers(double firstNumber, double secondNumber){
        double sum = firstNumber + secondNumber;
        return sum;
    }

    public static double subtractTwoNumbers(double firstNumber, double secondNumber){
        double difference = firstNumber - secondNumber;
        return difference;
    }

    public static double multiplyTwoNumbers(double firstNumber, double secondNumber){
        double product = firstNumber * secondNumber;
        return product;
    }

    public static double divideTwoNumbers(double firstNumber, double secondNumber){
        double quotient = firstNumber / secondNumber;
        return quotient;
    }
}