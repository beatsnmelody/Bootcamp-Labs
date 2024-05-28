package displayManager;

import sandwichManager.Sandwich;

import java.util.Scanner;

public class Screen {

    public Sandwich currentSandwich;

    public void homeScreen(){

        while(true){

            System.out.println("Welcome to the deli shop lol");

            System.out.println("What you want");

            Scanner userInput = new Scanner(System.in);

            int homeScreenInput = Integer.parseInt(userInput.nextLine());

            switch(homeScreenInput){

                case 1:
                    orderScreen();
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Not an option");

            }

        }

    }

    public void orderScreen(){

        System.out.println("Hiiiii");

    }

}
