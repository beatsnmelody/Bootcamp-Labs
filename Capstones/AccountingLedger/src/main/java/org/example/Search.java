package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Search {

    public static void depositSearch(String username){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> deposits = new ArrayList<>();

        for (int i = transactions.size() - 1; i >= 0; i--){

            Transaction transaction = transactions.get(i);

            if (transaction.getAmount() > 0){
                deposits.add(transaction);
                System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
            }
        }

    }

    public static void paymentSearch (String username){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> payments = new ArrayList<>();

        for (int i = transactions.size() - 1; i >= 0; i--){

            Transaction transaction = transactions.get(i);

            if (transaction.getAmount() < 0){
                payments.add(transaction);
                System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
            }
        }

    }

    public static void monthToDate(String username, String monthInput){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> mtdResults = new ArrayList<>();

        try {

            for (int i = transactions.size() - 1; i >= 0; i--) {

                Transaction transaction = transactions.get(i);

                SimpleDateFormat sdf = new SimpleDateFormat("MM");
                Date dateToSearch = sdf.parse(monthInput);
                String dateToString = sdf.format(dateToSearch);

                SimpleDateFormat sdfTransaction = new SimpleDateFormat("MM");
                Date dateSearchResults = sdf.parse(transaction.getDate());
                String transactionDateToString = sdfTransaction.format(dateSearchResults);

                if(dateToString.equals(transactionDateToString)){
                    mtdResults.add(transaction);
                    System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
                }

            }
        }catch (ParseException ex){
            System.out.println("[SORRY, COULDN'T INTERPRET MONTH.]");
        }

    }

    public static List<Transaction> previousMonth(String username){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> prevMonthResults = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

            for (int i = transactions.size() - 1; i >= 0; i--) {

                Transaction transaction = transactions.get(i);

                DateTimeFormatter inputTransactionFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                LocalDate inputTransaction = LocalDate.parse(transaction.getDate(), inputTransactionFormatter);

                if (inputTransaction.isAfter(previousMonth) && inputTransaction.isBefore(firstDayOfMonth)) {
                    prevMonthResults.add(transaction);
                    System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
                }


            }

            return prevMonthResults;

    }

    public static void yearToDate(String username, String yearInput){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> ytdResults = new ArrayList<>();

        try {

            for (int i = transactions.size() - 1; i >= 0; i--) {

                Transaction transaction = transactions.get(i);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Date dateToSearch = sdf.parse(yearInput);
                String dateToString = sdf.format(dateToSearch);

                SimpleDateFormat sdfTransaction = new SimpleDateFormat("yyyy");
                Date dateSearchResults = sdf.parse(transaction.getDate());
                String transactionDateToString = sdfTransaction.format(dateSearchResults);

                if(dateToString.equals(transactionDateToString)){
                    ytdResults.add(transaction);
                    System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
                }

            }
        }catch (ParseException ex){
            System.out.println("[SORRY, COULDN'T INTERPRET YEAR.]");
        }

    }

    public static List<Transaction> previousYear(String username){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> prevYearResults = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minusYears(1);
        LocalDate firstDayOfYear = today.withDayOfYear(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {

            Transaction transaction = transactions.get(i);

            DateTimeFormatter inputTransactionFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate inputTransaction = LocalDate.parse(transaction.getDate(), inputTransactionFormatter);

            if (inputTransaction.isAfter(previousYear) && inputTransaction.isBefore(firstDayOfYear)) {
                prevYearResults.add(transaction);
                System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
            }


        }

        return prevYearResults;
    }

    public static void searchByVendor(String username, String userInput){

        List<Transaction> transactions = FileManager.readTransactionFromFile(username);

        List<Transaction> resultsByVendor = new ArrayList<>();

        for (int i = transactions.size() - 1; i >= 0; i--){

            Transaction transaction = transactions.get(i);

            if (Objects.equals(transaction.getVendor(), userInput)){
                resultsByVendor.add(transaction);
                System.out.printf("%s | %s | %s | %s | $%.2f | %s \n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount(), transaction.getUsername());
            }
        }
    }
}
