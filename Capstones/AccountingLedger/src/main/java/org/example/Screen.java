package org.example;

import java.util.Scanner;

public class Screen {

    public void preludeScreen(){

        System.out.println("""
                    
                    You are an accountant that has spent a little too much time working on your boss' stuff,
                    and you decided to prioritize yourself and your own money-making decisions for once.
                    You bought an AI assistant to help you on this journey, and they literally just noticed you were here.
                    """);

        homeScreen();

    }

    public void homeScreen(){

        while(true) {

            System.out.println("""
                    [YAWN...]
                    [OH, IT'S YOU. LET ME GUESS, YOU WANT TO UPDATE YOUR LEDGER?]
                    [TYPE IN A LETTER BELOW TO GET STARTED.]
                    -------------------------------------------------------------
                    D) ADD DEPOSIT
                    P) MAKE PAYMENT (DEBIT)
                    L) LEDGER
                    X) SEE YOU LATER.
                    """);

            Scanner userInput = new Scanner(System.in);

            String homeScreenInput = userInput.nextLine();

            switch (homeScreenInput.toUpperCase()){
                case "D":
                    System.out.println("[THIS IS THE DEPOSIT SCREEN.]");
                    break;
                case "P":
                    System.out.println("[THIS IS THE PAYMENT SCREEN.]");
                    break;
                case "L":
                    System.out.println("[THIS IS THE LEDGER SCREEN.]");
                    break;
                case "X":
                    System.exit(0);
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");
            }
        }

    }
}
