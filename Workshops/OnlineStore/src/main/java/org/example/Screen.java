package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Displays Home Screen, Product Screen, as well as a cart while the user is shopping
//also checkout screen when the user is done shopping
//initializes the arrayList from the info read from the bufferedReader
//calls bufferedWriter method when it's time to print out receipt
//AVOID RECURSIVE FUNCTIONS FOR SCREEN NAVIGATION
//wait...secret extra screen if I can implement the user/employee "login"

public class Screen {

    public void homeScreen(){

        while(true){

            Scanner userInput = new Scanner(System.in);

            System.out.println(">>>>>>>>>>>The Shop's Home Screen<<<<<<<<<<<<");
            System.out.println("The air is filled with dust old and new, \nbut you feel strangely at home in this place. \n");
            System.out.println("'Why hello there! I'm the store owner, and this interface is provided by my lovely wife!' \n");
            System.out.println("""
                               {BZZRT...CHOOSE A NUMBER TO PROCEED.}
                               1) VIEW AVAILABLE PRODUCTS
                               2) LISTEN TO MY HUSBAND'S RAMBLINGS
                               3) EXIT
                               """);
            try {

                int homeScreenSelection = Integer.parseInt(userInput.nextLine());

                switch (homeScreenSelection) {
                    case 1:
                        //displays all available products
                        displayProductsScreen(true);
                        break;
                    case 2:
                        //you want lore? you got lore
                        System.out.println("{HMM...YOU WANT TO KNOW MORE ABOUT MY HUSBAND?} \n{I'LL ALLOW IT.}");
                        break;
                    case 3:
                        //exits out of the program
                        System.exit(0);
                    default:
                        System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");
                }

            }catch (NumberFormatException | InterruptedException ex){
                System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");
            }
        }

    }

    public void displayProductsScreen(boolean isEnabled) throws InterruptedException {

        while(isEnabled) {

            System.out.println(">>>>>>>>>>>Our Wonderful Products<<<<<<<<<<<<");

            FileManager.getProducts();

            Scanner userInput = new Scanner(System.in);

            System.out.println("""
                               {PLEASE CHOOSE FROM ONE OF THE FOLLOWING OPTIONS.}
                               1) REFINE SEARCH
                               2) ADD ITEM TO CART
                               3) BACK TO HOME
                               """);

            try {
                int productScreenSelection = Integer.parseInt(userInput.nextLine());


                switch (productScreenSelection) {
                    case 1:
                        //allows user to filter products
                        searchProductsScreen(true);
                        break;
                    case 2:
                        //allows user to add item to cart
                        System.out.println("{ADD ITEM TO CART?}");
                        break;
                    case 3:
                        //returns user back to home screen
                        homeScreen();
                        isEnabled = false;
                        break;
                    default:
                        System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");
                        System.out.println("{RETURNING TO PRODUCT LIST...}");
                        Thread.sleep(1000);
                }
            }catch (NumberFormatException ex){

                System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");
                System.out.println("{RETURNING TO PRODUCT LIST...}");
                Thread.sleep(1000);

            }

        }

    }

    public void searchProductsScreen(boolean isEnabled){

        while (isEnabled) {

            Scanner userInput = new Scanner(System.in);

            System.out.println("""
                    {WHAT DO YOU WANT TO REFINE YOUR SEARCH BY? PLEASE CHOOSE A NUMBER.}
                    1)Name
                    2)Price
                    3)Department
                    """);

            try {

                int searchInput = Integer.parseInt(userInput.nextLine());

                switch (searchInput) {
                    case 1:
                        searchProductByName();
                    case 2:
                        //filters product by price
                    case 3:
                        //filters product by department
                    default:
                        System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");
                }

            } catch (NumberFormatException ex) {

                System.out.println("{THIS ISN'T AN OPTION I RECOGNIZE.}");

            }
        }
    }

    public void searchProductByName(){

        List<Product> products = FileManager.getProducts();

        List<Product> productNames = new ArrayList<>(products);

        for(Product product: productNames){

            Scanner userInput = new Scanner(System.in);

            System.out.println("{WHAT IS THE NAME OF THE PRODUCT YOU WANT TO SEARCH?}");

            String nameSearchInput = userInput.nextLine();

            if (product.getName().contains(nameSearchInput)){

                System.out.println("{RESULTS FOR:}" + nameSearchInput);
                System.out.printf("SKU: %d Name: %s \nPrice $%.2f Category: %s \nDescription: %s \n", product.getSKU(), product.getName(), product.getPrice(), product.getCategory(), product.getDescription());

            }else{
                System.out.println("{SORRY, CANNOT FIND ANYTHING WITH YOUR INPUT.}");
            }

        }

    }
    
}
