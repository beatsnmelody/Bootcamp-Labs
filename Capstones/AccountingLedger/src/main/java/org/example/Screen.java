package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

                System.out.println("[ANALYZING USER...]");

                double currentBalance = FileManager.getUserBalance(userName, 50.00);

                System.out.println("\n[....................................]");
                System.out.println("\n[OH, I REMEMBER YOU. YOUR NAME IS " + user.getName().toUpperCase() + ", AND YOUR CURRENT BALANCE IS " + currentBalance + " DOLLARS.]\n");

                homeScreen();

            }else if (user.getName() == null){

                User newUser = new User(userName, 50.00);

                System.out.printf("[GREAT, SO YOUR USERNAME IS %s, AND YOUR BALANCE IS $%.2f DOLLARS.]", userName.toUpperCase(), newUser.getBalance());

                FileManager.writeUserToFile(newUser);

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
                    \n[YAWN...]
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
                    ledgerScreen(true);
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

                System.out.println("[ENTER THE DATE OF THE DEPOSIT IN NUMBERS. ENTER IT AS MONTH-DAY-YEAR.]");
                String dateInput = userInput.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                Date transactionDate = sdf.parse(dateInput);
                String finalDateInput = sdf.format(transactionDate);

                System.out.println("[ENTER THE TIME OF THE DEPOSIT IN NUMBERS. INCLUDE SECONDS IF POSSIBLE.]");
                String timeInput = userInput.nextLine();
                LocalTime transactionTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm:ss"));
                String finalTimeInput = transactionTime.toString();

                System.out.println("[SO, IS THIS A PAYCHECK? ENTER A SHORT DESCRIPTION HERE. DON'T GIVE ME A NOVEL.]");
                String descriptionInput = userInput.nextLine();

                System.out.println("[GREAT. NOW, WHO WAS INVOLVED IN THIS DEPOSIT? PROBABLY YOU.]");
                String vendorInput = userInput.nextLine();

                System.out.println("[OK, ONE LAST THING. WHAT'S THE AMOUNT OF THIS DEPOSIT?]");
                double amountInput = Double.parseDouble(userInput.nextLine());

                String username = currentUser.getName();

                Transaction newTransaction = new Transaction(finalDateInput, finalTimeInput, descriptionInput, vendorInput, amountInput, username);
                FileManager.writeTransactionToFile(newTransaction, username);

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
                    System.out.println("[OK...TAKING YOU BACK TO THE DEPOSIT SCREEN.]\n");
                    break;
                case "N":
                    System.out.println("[THAT'S HOW THE COOKIE CRUMBLES. TAKING YOU BACK TO THE HOME SCREEN.]\n");
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

            System.out.println("[ARE YOU HERE BECAUSE YOU LOST MONEY? IT BETTER HAVE BEEN FOR SOMETHING RESPONSIBLE.]");

            Scanner userInput = new Scanner(System.in);

            try {

                System.out.println("[ENTER THE DATE OF THE PAYMENT IN NUMBERS. ENTER IT AS MONTH-DAY-YEAR.]");
                String dateInput = userInput.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                Date transactionDate = sdf.parse(dateInput);
                String finalDateInput = sdf.format(transactionDate);

                System.out.println("[ENTER THE TIME OF THE PAYMENT IN NUMBERS. INCLUDE SECONDS IF POSSIBLE.]");
                String timeInput = userInput.nextLine();
                LocalTime transactionTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm:ss"));
                String finalTimeInput = transactionTime.toString();

                System.out.println("[SO, WHAT WAS THIS PAYMENT FOR? ENTER A SHORT DESCRIPTION HERE. DON'T GIVE ME A NOVEL.]");
                String descriptionInput = userInput.nextLine();

                System.out.println("[GREAT. NOW, WHO DID YOU PAY TO?]");
                String vendorInput = userInput.nextLine();

                System.out.println("[OK, ONE LAST THING. WHAT'S THE AMOUNT YOU WITHDREW? TYPE THIS AS A NEGATIVE NUMBER.]");
                double amountInput = Double.parseDouble(userInput.nextLine());

                if (amountInput > 0){
                    System.out.println("[THIS IS AN INVALID ENTRY. I SAID A NEGATIVE NUMBER.]");
                }

                String username = currentUser.getName();

                Transaction newTransaction = new Transaction(finalDateInput, finalTimeInput, descriptionInput, vendorInput, amountInput, username);
                FileManager.writeTransactionToFile(newTransaction, username);

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
                    System.out.println("[UGH...TAKING YOU BACK TO THE PAYMENT SCREEN.]\n");
                    break;
                case "N":
                    System.out.println("[OH? TAKING YOU BACK TO THE HOME SCREEN.]\n");
                    isEnabled = false;
                    homeScreen();
                    break;
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");

            }

        }
    }

    public void ledgerScreen(boolean isEnabled){

        while (isEnabled) {

            Scanner userInput = new Scanner(System.in);

            System.out.println("\n[YOU CAN VIEW YOUR TRANSACTION HISTORY HERE.]");
            System.out.println("[WHAT KIND OF TRANSACTIONS DO YOU WANT TO SEE...OR DO YOU WANT TO RUN A REPORT TO FILTER YOUR TRANSACTIONS?]");
            System.out.println("""
                    A) ALL TRANSACTIONS
                    D) DEPOSITS
                    P) PAYMENTS
                    R) NEW REPORT
                    H) HOME SCREEN
                    """);

            String ledgerInput = userInput.nextLine();

            switch (ledgerInput.toUpperCase()){
                case "A":
                    FileManager.displayTransactions(currentUser.getName(), FileManager.readTransactionFromFile(currentUser.getName()));
                    break;
                case "D":
                    Search.depositSearch(currentUser.getName());
                    break;
                case "P":
                    Search.paymentSearch(currentUser.getName());
                    break;
                case "R":
                    reportsScreen(true);
                    isEnabled = false;
                    break;
                case "H":
                    System.out.println("[CAN'T MAKE UP YOUR MIND? TAKING YOU BACK TO THE HOME SCREEN.]");
                    homeScreen();
                    isEnabled = false;
                    break;
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");
            }

        }
    }

    public void reportsScreen(boolean isEnabled){

        while (isEnabled){

            Scanner userInput = new Scanner(System.in);

            System.out.println("\n[SO, YOU DO WANT TO SEE YOUR REPORTS, HUH?]");
            System.out.println("[DO YOU WANT TO RUN A PRE-DEFINED REPORT OR SEARCH BY VENDOR?]");
            System.out.println("""
                    1) MONTH TO DATE
                    2) PREVIOUS MONTH
                    3) YEAR TO DATE
                    4) PREVIOUS YEAR
                    5) SEARCH BY VENDOR
                    0) GO BACK TO THE REPORTS PAGE
                    """);

            int reportsInput = Integer.parseInt(userInput.nextLine());

            switch (reportsInput){
                case 1:
                    System.out.println("[ENTER THE MONTH YOU WANT TO SEARCH FOR. ENTER IT IN NUMBERS.]");
                    String monthInput = userInput.nextLine();
                    Search.monthToDate(currentUser.getName(), monthInput);
                    break;
                case 2:
                    System.out.println("[HERE'S YOUR TRANSACTIONS FOR THE PREVIOUS MONTH.]");
                    Search.previousMonth(currentUser.getName());
                    break;
                case 3:
                    System.out.println("[ENTER THE YEAR YOU WANT TO SEARCH FOR.]");
                    String yearInput = userInput.nextLine();
                    Search.yearToDate(currentUser.getName(), yearInput);
                    break;
                case 4:
                    System.out.println("[HERE'S YOUR TRANSACTIONS FOR THE PREVIOUS YEAR.]");
                    Search.previousYear(currentUser.getName());
                    break;
                case 5:
                    System.out.println("\n[ENTER THE NAME OF THE VENDOR HERE. BE SPECIFIC.]");
                    String vendorInput = userInput.nextLine();
                    Search.searchByVendor(currentUser.getName(), vendorInput);
                    break;
                case 0:
                    System.out.println("[YOU REALLY CAN'T MAKE UP YOUR MIND TODAY...TAKING YOU BACK TO THE HOME SCREEN.]");
                    homeScreen();
                    isEnabled = false;
                    break;
                default:
                    System.out.println("[...I ASSUME YOU TYPED IN SOMETHING WRONG. PLEASE SELECT A VALID LETTER.]\n");
            }

        }
    }
}
