package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    //write and read transaction will require username as well as transaction
    //set

    public static void writeTransactionToFile(Transaction transaction){

        String filePath = "src/main/resources/ledger.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){

            System.out.println("[ENTERING TRANSACTION...]");

            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());

            writer.newLine();

            System.out.println("[TRANSACTION SUCCESSFULLY ENTERED.]");

        }
        catch (IOException ex){

            System.out.println("[OOPS, CAN'T PUT THAT TRANSACTION THERE.]");

        }
    }

    public static List<Transaction> readTransactionFromFile(String username){

        List<Transaction> transactions = new ArrayList<>();

        String filePath = "src/main/resources/ledger.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){

                String[] data = line.split("\\|");
                String date = data[0];
                String time = data[1];
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4].replace(",", ""));
                String transactionUsername = data[5];

                //grab username now as well
                //is the user the one doing the transaction (must check)
                //

                Transaction transaction = new Transaction(date, time, description, vendor, amount, username);

                if(username.equalsIgnoreCase(transactionUsername)) {
                    transactions.add(transaction);
                }

            }

        }catch(IOException ex){
            System.out.println("[OOPS, COULDN'T FIND TRANSACTIONS.]");
        };

        return transactions;
    }

    public static void writeUserToFile(User user){

        String filePath = "src/main/resources/users.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){

            System.out.println("[REGISTERING USER...]");

            writer.write(user.getName() + "|" + user.getBalance());

            writer.newLine();

            System.out.println("[USER REGISTERED SUCCESSFULLY.]");

        }
        catch (IOException ex){

            System.out.println("[OOPS, CAN'T PUT THAT USER THERE.]");

        }
    }

    public static List<User> readUserFromFile(){

        List<User> users = new ArrayList<>();

        String filePath = "src/main/resources/users.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){

                String[] data = line.split("\\|");
                String name = data[0];
                double balance = Double.parseDouble(data[1].replace(",", ""));

                User user = new User(name, balance);
                users.add(user);

            }

        }catch(IOException ex){
            System.out.println("[OOPS, COULDN'T FIND USERS.]");
        };

        return users;
    }
}
