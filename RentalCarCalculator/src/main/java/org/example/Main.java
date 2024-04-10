package org.example;

import java.util.Scanner;

//Psuedocode yay!
//Import the scanner and initialize it!
//Ask for input on the following info...
//pickup date (string)
//number of days for rental (int)
//do you want a toll tag? (boolean)
//gps? (boolean)
//roadside assistance? (boolean)
//and lastly, their current age (int)

//first, calculate the basic car rental...$29.99 * numberOfRentDays
//then, apply a price increase of 30% on the basic charge ONLY if the driver is under 25
//basicCarRental * 1.3 = youngsterCarRental
//Then, use if statements to see what options the user chose, and multiply each option * numberOfRentDays if an option is true
//from there, calculate the total cost by adding basicCarRental (or youngsterCarRental) (use if to decide this) and totalOptionCost together

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome! This is the car rentals department. \n If you're interested in renting a car,complete the form below and we'll have a price for you!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("When will you pick up the car?");
        String pickupDate = scanner.nextLine();

        System.out.println("How many days will you rent?");
        int numberOfRentDays = scanner.nextInt();

        System.out.println("Do you want a toll tag?");
        boolean hasTollTag = scanner.nextBoolean();

        System.out.println("Do you want a GPS device?");
        boolean hasGPS = scanner.nextBoolean();

        System.out.println("Do you want roadside assistance?");
        boolean hasRoadAssistance = scanner.nextBoolean();

        System.out.println("How old are you?");
        int currentAge = scanner.nextInt();

        double carRentalCharge;
        if (currentAge < 25) {
            carRentalCharge = 29.99 * (double) numberOfRentDays * 1.3;
        }else{
            carRentalCharge = 29.99 * (double) numberOfRentDays;
        }

        double optionsCost = 0.0;
        if (hasTollTag){
            optionsCost = 3.95 * (double) numberOfRentDays;
        } else if (hasGPS) {
            optionsCost = 2.95 * (double) numberOfRentDays;
        } else if (hasRoadAssistance){
            optionsCost = 3.95 * (double) numberOfRentDays;
        }

        double totalCost = carRentalCharge + optionsCost;
        System.out.println("You pick up your car on: " + pickupDate + ", and your total cost is: " + totalCost);
    }
}