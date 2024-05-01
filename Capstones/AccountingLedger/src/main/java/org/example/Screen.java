package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Screen {

    public User currentUser;

    public void preludeScreen(){

        System.out.println("""
                    
                    You are an accountant that has spent a little too much time working on your boss' stuff,
                    and you decided to prioritize yourself and your own money-making decisions for once.
                    You bought an AI assistant to help you on this journey, and they literally just noticed you were here.
                    """);

        Scanner userInput = new Scanner(System.in);

        List<User> users = FileManager.readUserFromFile();

        System.out.println("[...WHAT'S YOUR NAME AGAIN?]");

        String userName = userInput.nextLine();

        for(User user : users){

            if (Objects.equals(userName, user.getName())){

                this.currentUser = user;

                System.out.println("[OH, I REMEMBER YOU. YOUR NAME IS " + user.getName().toUpperCase() + ", AND YOUR CURRENT BALANCE IS " + user.getBalance() + " DOLLARS.]\n");

                homeScreen();

            }else if (user.getName() == null){

                User newUser = new User(userName, 50.00);

                System.out.println("[GREAT, SO YOUR USERNAME IS " + userName.toUpperCase() + ", AND YOUR BALANCE IS " + newUser.getBalance() + " DOLLARS.]\n");

                this.currentUser = newUser;

                homeScreen();

            }

        }

        //loop through all users from file
        //if username matches, then set user variable to currentUser
        //if null by end of loop, create new user

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
                    depositScreen(true);
                    break;
                case "P":
                    paymentScreen(true);
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

    public void depositScreen(boolean isEnabled){

        while(isEnabled) {

            System.out.println("[SO...YOU GOT YOUR PAYCHECK OR SOMETHING? I'M LISTENING...]");

            Scanner userInput = new Scanner(System.in);

            try {

                System.out.println("[ENTER THE DATE OF THE DEPOSIT IN NUMBERS.]");
                String dateInput = userInput.nextLine();
                Date transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
                String finalDateInput = transactionDate.toString();

                System.out.println("[ENTER THE TIME OF THE DEPOSIT IN NUMBERS. INCLUDE SECONDS IF POSSIBLE.]");
                String timeInput = userInput.nextLine();
                LocalTime transactionTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("hh:mm:ss"));
                String finalTimeInput = transactionTime.toString();

                System.out.println("[SO, IS THIS A PAYCHECK? ENTER A SHORT DESCRIPTION HERE. DON'T GIVE ME A NOVEL.]");
                String descriptionInput = userInput.nextLine();

                System.out.println("[GREAT. NOW, WHO WAS INVOLVED IN THIS DEPOSIT? PROBABLY YOU.]");
                String vendorInput = userInput.nextLine();

                System.out.println("[OK, ONE LAST THING. WHAT'S THE AMOUNT OF THIS DEPOSIT?]");
                double amountInput = Double.parseDouble(userInput.nextLine());

                String username = currentUser.getName();

                Transaction newTransaction = new Transaction(finalDateInput, finalTimeInput, descriptionInput, vendorInput, amountInput, username);
                FileManager.writeTransactionToFile(newTransaction);

                double newBalance = MoneyTransfer.depositFunction(amountInput, currentUser.getBalance());

                currentUser.setBalance(newBalance);

            } catch (ParseException ex) {
                System.out.println("[SORRY, CAN'T INTERPRET THE DATE/TIME YOU PUT.]");
            }

            System.out.println("""
                    [SO...DO YOU SOMEHOW HAVE ANOTHER DEPOSIT TO MAKE?]
                    Y) YES
                    N) NO
                    """);

            String multiDepositInput = userInput.nextLine();

            switch (multiDepositInput.toUpperCase()) {

                case "Y":
                    System.out.println("[OK...TAKING YOU BACK TO THE DEPOSIT SCREEN.\n");
                    continue;
                case "N":
                    System.out.println("[THAT'S HOW THE COOKIE CRUMBLES. TAKING YOU BACK TO THE HOME SCREEN.]");
                    isEnabled = false;
                    homeScreen();
                    break;
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");

            }
        }


    }

    public void paymentScreen(boolean isEnabled){

        while(isEnabled){

            System.out.println("[ARE YOU HERE BECAUSE YOU LOST MONEY? IT BETTER HAVE BEEN FOR SOMETHING RESPONSIBLE.");

            Scanner userInput = new Scanner(System.in);

            try {

                System.out.println("[ENTER THE DATE OF THE PAYMENT IN NUMBERS.]");
                String dateInput = userInput.nextLine();
                Date transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
                String finalDateInput = transactionDate.toString();

                System.out.println("[ENTER THE TIME OF THE PAYMENT IN NUMBERS. INCLUDE SECONDS IF POSSIBLE.]");
                String timeInput = userInput.nextLine();
                LocalTime transactionTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("hh:mm:ss"));
                String finalTimeInput = transactionTime.toString();

                System.out.println("[SO, WHAT WAS THIS PAYMENT FOR? ENTER A SHORT DESCRIPTION HERE. DON'T GIVE ME A NOVEL.]");
                String descriptionInput = userInput.nextLine();

                System.out.println("[GREAT. NOW, WHO DID YOU PAY TO?]");
                String vendorInput = userInput.nextLine();

                System.out.println("[OK, ONE LAST THING. WHAT'S THE AMOUNT YOU WITHDREW?]");
                double amountInput = Double.parseDouble(userInput.nextLine());

                String username = currentUser.getName();

                Transaction newTransaction = new Transaction(finalDateInput, finalTimeInput, descriptionInput, vendorInput, amountInput, username);
                FileManager.writeTransactionToFile(newTransaction);

                double newBalance = MoneyTransfer.withdrawFunction(amountInput, currentUser.getBalance());

                currentUser.setBalance(newBalance);

            } catch (ParseException ex) {
                System.out.println("[SORRY, CAN'T INTERPRET THE DATE/TIME YOU PUT.]");
            }

            System.out.println("""
                    [SO...DO YOU HAVE ANOTHER PAYMENT TO MAKE?]
                    Y) YES
                    N) NO
                    """);

            String multiPaymentInput = userInput.nextLine();

            switch (multiPaymentInput.toUpperCase()) {

                case "Y":
                    System.out.println("[UGH...TAKING YOU BACK TO THE PAYMENT SCREEN.\n");
                    continue;
                case "N":
                    System.out.println("[OH? TAKING YOU BACK TO THE HOME SCREEN.]");
                    isEnabled = false;
                    homeScreen();
                    break;
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");

            }

        }
    }
}
