package displayManager;

import orderManager.Chips;
import orderManager.Drink;
import orderManager.DrinkSize;
import orderManager.Order;
import sandwichManager.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {

    public Sandwich currentSandwich;
    public Ingredients currentIngredients;
    public Drink currentDrink;
    public Chips currentChips;

    public void homeScreen() {

        while (true) {

            System.out.println("Welcome to the deli shop lol");

            System.out.println("What you want");

            Scanner userInput = new Scanner(System.in);

            int homeScreenInput = Integer.parseInt(userInput.nextLine());

            switch (homeScreenInput) {

                case 1:
                    orderScreen(true);
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Not an option");

            }

        }

    }

    public void orderScreen(boolean isEnabled) {

        while (isEnabled) {

            Order currentOrder = new Order();

            System.out.println("What you want to add");

            Scanner userInput = new Scanner(System.in);

            int orderInput = Integer.parseInt(userInput.nextLine());

            switch (orderInput) {
                case 1:
                    if (currentSandwich != null) {
                    System.out.println("Sorry, you've already ordered a sandwich.");
                    }else{
                        sandwichScreen(currentOrder);
                    }
                    break;
                case 2:
                    drinkScreen(currentOrder);
                    break;
                case 3:
                    chipsScreen(currentOrder);
                    break;
                case 4:
                    if (currentOrder.getSandwich() != null || currentOrder.getDrink() != null || currentOrder.getChips() != null) {
                        checkOutScreen(currentOrder);
                    }else{
                        System.out.println("Sorry, your order is empty, bud.");
                    }
                    break;
                case 0:
                    currentOrder = null;
                    isEnabled = false;
                    homeScreen();
                    break;
                default:
                    System.out.println("Not an option");
            }

        }

    }

    public void sandwichScreen(Order currentOrder) {

        currentSandwich = new Sandwich();
        currentIngredients = new Ingredients();
        Scanner userInput = new Scanner(System.in);

        System.out.println("WELCOEM TO SANDWICH");

        System.out.println("What sizeee");
        System.out.println("""
                4) 4-INCH
                8) 8-INCH
                12) 12-INCH
                """);

        int sizeInput = Integer.parseInt(userInput.nextLine());

        switch(sizeInput){
            case 4:
                currentSandwich.setSize(Size.FOUR_INCH);
                break;
            case 8:
                currentSandwich.setSize(Size.EIGHT_INCH);
                break;
            case 12:
                currentSandwich.setSize(Size.TWELVE_INCH);
                break;
            default:
                System.out.println("Not an option");
        }

        addBread(currentOrder);

        System.out.println("Meat for ur wich? YES/NO");
        String yesNoMeat = userInput.nextLine();

        switch (yesNoMeat.toUpperCase()) {
            case "YES":
                addMeat(currentOrder);
                break;
            case "NO":
                System.out.println("No meat :(");
                break;
            default:
                System.out.println("Not an option");
        }

        System.out.println("Any cheese? YES/NO");
        String yesNoCheese = userInput.nextLine();

        switch (yesNoCheese.toUpperCase()) {
            case "YES":
                addCheese(currentOrder);
                break;
            case "NO":
                System.out.println("No cheese, then.");
                break;
            default:
                System.out.println("Not an option");
        }

        System.out.println("Any toppings? YES/NO");
        String yesNoToppings = userInput.nextLine();

        switch(yesNoToppings.toUpperCase()){
            case "YES":
                addToppings(currentOrder);
                break;
            case "NO":
                System.out.println("No toppings, then.");
                break;
            default:
                System.out.println("Not an option");
        }

        System.out.println("And last but not least, any sauce? YES/NO");
        String yesNoSauce = userInput.nextLine();

        switch(yesNoSauce.toUpperCase()){
            case "YES":
                addSauce(currentOrder);
                break;
            case "NO":
                System.out.println("And plain it is.");
                break;
            default:
                System.out.println("Not an option");
        }

        System.out.println("And voila! Here's your sandwich. Adding it now...");
        currentSandwich.setIngredients(currentIngredients);
        orderScreen(true);

    }

    public void addBread(Order currentOrder) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Bread?");
        System.out.println("""
                WHITE
                WHEAT
                RYE
                WRAP
                """);

        String breadInput = userInput.nextLine();

        switch (breadInput.toUpperCase()) {
            case "WHITE":
                currentIngredients.setBread(Bread.WHITE);
                break;
            case "WHEAT":
                currentIngredients.setBread(Bread.WHEAT);
                break;
            case "RYE":
                currentIngredients.setBread(Bread.RYE);
                break;
            case "WRAP":
                currentIngredients.setBread(Bread.WRAP);
                break;
            default:
                System.out.println("Not an option");
        }

        sandwichScreen(currentOrder);

    }

    public void addMeat(Order currentOrder) {

        List<Meat> meatList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        System.out.println("How about meat?");
        System.out.println("""
                STEAK
                HAM
                SALAMI
                ROAST BEEF
                CHICKEN
                BACON
                BACK TO SANDWICH (ORDER)
                """);

        String meatInput = userInput.nextLine();

        switch (meatInput.toUpperCase()) {
            case "STEAK":
                meatList.add(Meat.STEAK);
                break;
            case "HAM":
                meatList.add(Meat.HAM);
                break;
            case "SALAMI":
                meatList.add(Meat.SALAMI);
                break;
            case "ROAST BEEF":
                meatList.add(Meat.ROAST_BEEF);
                break;
            case "CHICKEN":
                meatList.add(Meat.CHICKEN);
                break;
            case "BACON":
                meatList.add(Meat.BACON);
                break;
            case "ORDER":
                if (meatList.isEmpty()){
                    meatList = null;
                    sandwichScreen(currentOrder);
                }
                sandwichScreen(currentOrder);
                break;
            default:
                System.out.println("Not an option");

        }

        currentIngredients.setMeat(meatList);

    }

    public void addCheese(Order currentOrder){

        List<Cheese> cheeseList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        System.out.println("How about cheese?");
        System.out.println("""
                AMERICAN
                PROVOLONE
                CHEDDAR
                SWISS
                BACK TO SANDWICH (ORDER)
                """);

        String cheeseInput = userInput.nextLine();

        switch(cheeseInput.toUpperCase()){
            case "AMERICAN":
                cheeseList.add(Cheese.AMERICAN);
                break;
            case "PROVOLONE":
                cheeseList.add(Cheese.PROVOLONE);
                break;
            case "CHEDDAR":
                cheeseList.add(Cheese.CHEDDAR);
                break;
            case "SWISS":
                cheeseList.add(Cheese.SWISS);
                break;
            case "ORDER":
                if (cheeseList.isEmpty()){
                    cheeseList = null;
                    sandwichScreen(currentOrder);
                }
                sandwichScreen(currentOrder);
                break;
            default:
                System.out.println("Not an option");

        }

        currentIngredients.setCheese(cheeseList);

    }

    public void addToppings(Order currentOrder){

        List<Toppings> toppingsList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        System.out.println("How about toppings?");
        System.out.println("""
                LETTUCE
                PEPPERS
                ONIONS
                TOMATOES
                JALAPENOS
                CUCUMBERS
                PICKLES
                GUACAMOLE
                MUSHROOMS
                BACK TO (ORDER)
                """);

        String toppingsInput = userInput.nextLine();

        switch(toppingsInput.toUpperCase()){
            case "LETTUCE":
                toppingsList.add(Toppings.LETTUCE);
                break;
            case "PEPPERS":
                toppingsList.add(Toppings.PEPPERS);
                break;
            case "ONIONS":
                toppingsList.add(Toppings.ONIONS);
                break;
            case "TOMATOES":
                toppingsList.add(Toppings.TOMATOES);
                break;
            case "JALAPENOS":
                toppingsList.add(Toppings.JALAPENOS);
                break;
            case "CUCUMBERS":
                toppingsList.add(Toppings.CUCUMBERS);
                break;
            case "PICKLES":
                toppingsList.add(Toppings.PICKLES);
                break;
            case "GUACAMOLE":
                toppingsList.add(Toppings.GUACAMOLE);
                break;
            case "MUSHROOMS":
                toppingsList.add(Toppings.MUSHROOMS);
                break;
            case "ORDER":
                if (toppingsList.isEmpty()){
                    toppingsList = null;
                    sandwichScreen(currentOrder);
                }
                sandwichScreen(currentOrder);
                break;
            default:
                System.out.println("Not an option");
        }

        currentIngredients.setToppings(toppingsList);

    }

    public void addSauce(Order currentOrder){

        List<Sauce> sauceList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        System.out.println("How about topping that off with some sauce?");
        System.out.println("""
                MAYO
                MUSTARD
                KETCHUP
                RANCH
                THOUSAND ISLAND
                VINAIGRETTE
                BACK TO (ORDER)
                """);

        String sauceInput = userInput.nextLine();

        switch(sauceInput.toUpperCase()){
            case "MAYO":
                sauceList.add(Sauce.MAYO);
                break;
            case "MUSTARD":
                sauceList.add(Sauce.MUSTARD);
                break;
            case "KETCHUP":
                sauceList.add(Sauce.KETCHUP);
                break;
            case "RANCH":
                sauceList.add(Sauce.RANCH);
                break;
            case "THOUSAND ISLAND":
                sauceList.add(Sauce.THOUSAND_ISLAND);
                break;
            case "VINAIGRETTE":
                sauceList.add(Sauce.VINAIGRETTE);
                break;
            case "ORDER":
                if (sauceList.isEmpty()){
                    sauceList = null;
                    sandwichScreen(currentOrder);
                }
                sandwichScreen(currentOrder);
                break;
            default:
                System.out.println("Not an option");
        }

        currentIngredients.setSauce(sauceList);

    }

    public void chipsScreen(Order currentOrder) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What chips do you want?");
        System.out.println("""
                PLAIN
                BARBECUE
                SALT AND VINEGAR
                JALAPENO
                BACK TO (ORDER)
                """);

        String chipsInput = userInput.nextLine();

        switch(chipsInput.toUpperCase()){
            case "PLAIN":
                currentChips = Chips.PLAIN;
                break;
            case "BARBECUE":
                currentChips = Chips.BARBECUE;
                break;
            case "SALT AND VINEGAR":
                currentChips = Chips.SALT_AND_VINEGAR;
                break;
            case "JALAPENO":
                currentChips = Chips.JALAPENO;
                break;
            case "ORDER":
                orderScreen(true);
                break;
            default:
                System.out.println("Not an option");
        }


    }

    public void drinkScreen(Order currentOrder) {

        currentDrink = new Drink();

        Scanner userInput = new Scanner(System.in);

        System.out.println("What size do you want your drink?");
        System.out.println("""
                SMALL
                MEDIUM
                LARGE
                GODZILLA
                BACK TO (ORDER)
                """);

        String drinkSizeInput = userInput.nextLine();

        switch(drinkSizeInput.toUpperCase()){
            case "SMALL":
                currentDrink.setDrinkSize(DrinkSize.SMALL);
            case "MEDIUM":
                currentDrink.setDrinkSize(DrinkSize.MEDIUM);
            case "LARGE":
                currentDrink.setDrinkSize(DrinkSize.LARGE);
            case "GODZILLA":
                currentDrink.setDrinkSize(DrinkSize.GODZILLA);
            case "ORDER":
                currentDrink = null;
                orderScreen(true);
            default:
                System.out.println("Not an option");

        }

        

    }

    public void checkOutScreen(Order currentOrder) {

    }
}
