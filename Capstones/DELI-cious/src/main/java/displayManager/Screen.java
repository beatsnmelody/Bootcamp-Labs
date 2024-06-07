package displayManager;

import orderManager.*;
import sandwichManager.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen {

    public Order currentOrder;
    public Sandwich currentSandwich;
    public Ingredients currentIngredients;
    public Drink currentDrink;
    public Chips currentChips;

    public void homeScreen() {

        while (true) {

            System.out.println("Welcome to DELI-cious!");

            System.out.println("What do you want? Type in a number.");
            System.out.println("""
                    1) NEW ORDER
                    0) QUIT
                    """);

            Scanner userInput = new Scanner(System.in);

            int homeScreenInput = Integer.parseInt(userInput.nextLine());

            switch (homeScreenInput) {

                case 1:
                    orderScreen(true);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Not an option");

            }

        }

    }

    public void orderScreen(boolean isEnabled) {

        while (isEnabled) {

            currentOrder = new Order();

            System.out.println("What item do you want to add? Type in a number.");
            System.out.println("""
                    1) SANDWICH
                    2) DRINK
                    3) CHIPS
                    4) CHECKOUT
                    0) QUIT ORDER
                    """);

            Scanner userInput = new Scanner(System.in);

            int orderInput = Integer.parseInt(userInput.nextLine());

            switch (orderInput) {
                case 1:
                    if (currentOrder.getSandwich().isPresent()) {
                        System.out.println("Sorry, you've already ordered a sandwich.");
                        break;
                    }
                        sandwichSizeAndBreadScreen();
                    break;
                case 2:
                    if (currentOrder.getDrink().isPresent()) {
                        System.out.println("Sorry, you've already ordered a drink.");
                        break;
                    }
                    drinkScreen();
                    break;
                case 3:
                    if (currentOrder.getChips().isPresent()) {
                        System.out.println("Sorry, you've already ordered chips.");
                        break;
                    }
                    chipsScreen();
                    break;
                case 4:
                    if (currentOrder.getSandwich().isPresent() || currentOrder.getDrink().isPresent() || currentOrder.getChips().isPresent()) {
                        checkOutScreen();
                        break;
                    }
                        System.out.println("Sorry, your order is empty, bud.");

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

    public void sandwichSizeAndBreadScreen() {

        currentSandwich = new Sandwich();
        currentIngredients = new Ingredients();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to the greatest sandwich maker of all time!");

        System.out.println("What size sandwich do you want? Type in a number.");
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

        addBread();

    }

    public void addBread() {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What kind of bread do you want? Type the full name of the bread.");
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

        System.out.println(currentIngredients.getBread().toString() + " is your current bread.");

        meatScreen();

    }

    public void meatScreen(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Do you want any meat? (YES)/(NO)");
        String yesNoMeat = userInput.nextLine();

        switch (yesNoMeat.toUpperCase()) {
            case "YES":
                addMeat(true);
                break;
            case "NO":
                System.out.println("No meat, then.");
                cheeseScreen();
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void addMeat(boolean isEnabled) {

        List<Meat> meatList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        while (isEnabled) {

            System.out.println("How about meat? Type the full name of the meat.");
            System.out.println("""
                    STEAK
                    HAM
                    SALAMI
                    ROAST BEEF
                    CHICKEN
                    BACON
                    TAKE ME TO THE NEXT SCREEN (CHEESE)
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
                case "CHEESE":
                    if (meatList.isEmpty()) {
                        meatList = null;
                        isEnabled = false;
                        cheeseScreen();
                        break;
                    }
                    isEnabled = false;
                    cheeseScreen();
                    break;
                default:
                    System.out.println("Not an option");

            }

            currentIngredients.setMeat(meatList);

            System.out.println(currentIngredients.getMeat().toString() + " are currently ordered.");

            System.out.println("Want any more kinds of meat? YES/NO");
            String yesNoToMultiple = userInput.nextLine();

            switch (yesNoToMultiple.toUpperCase()){
                case "YES":
                    System.out.println("Back to the meat screen you go!");
                    continue;
                case "NO":
                    isEnabled = false;
                    break;
                default:
                    System.out.println("Not an option");
            }
        }

        System.out.println("Do you want extra meat with your order? (YES)/(NO)");
        String extraMeatInput = userInput.nextLine();

        switch(extraMeatInput.toUpperCase()){
            case "YES":
                currentIngredients.setHasExtraMeat(true);
                cheeseScreen();
                break;
            case "NO":
                System.out.println("No extra meat, I see.");
                cheeseScreen();
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void cheeseScreen(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Any cheese? (YES)/(NO)");
        String yesNoCheese = userInput.nextLine();

        switch (yesNoCheese.toUpperCase()) {
            case "YES":
                addCheese(true);
                break;
            case "NO":
                System.out.println("No cheese, then.");
                toppingsScreen();
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void addCheese(boolean isEnabled){

        List<Cheese> cheeseList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        while (isEnabled) {

            System.out.println("How about cheese? Type the full name of the cheese.");
            System.out.println("""
                    AMERICAN
                    PROVOLONE
                    CHEDDAR
                    SWISS
                    TAKE ME TO THE NEXT SCREEN (TOPPINGS)
                    """);

            String cheeseInput = userInput.nextLine();

            switch (cheeseInput.toUpperCase()) {
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
                case "TOPPINGS":
                    if (cheeseList.isEmpty()) {
                        cheeseList = null;
                        isEnabled = false;
                        toppingsScreen();
                        break;
                    }
                    isEnabled = false;
                    toppingsScreen();
                    break;
                default:
                    System.out.println("Not an option");

            }

            currentIngredients.setCheese(cheeseList);

            System.out.println(currentIngredients.getCheese().toString() + " are currently ordered.");

            System.out.println("Want any more kinds of cheese? (YES)/(NO)");
            String yesNoToMultiple = userInput.nextLine();

            switch (yesNoToMultiple.toUpperCase()){
                case "YES":
                    System.out.println("Back to the cheese screen you go!");
                    continue;
                case "NO":
                    isEnabled = false;
                    break;
                default:
                    System.out.println("Not an option");
            }

        }

        System.out.println("Do you want extra cheese with your order? (YES)/(NO)");
        String extraCheeseInput = userInput.nextLine();

        switch(extraCheeseInput.toUpperCase()){
            case "YES":
                currentIngredients.setHasExtraCheese(true);
                toppingsScreen();
                break;
            case "NO":
                System.out.println("No extra cheese, I see.");
                toppingsScreen();
                break;
            default:
                System.out.println("Not an option");
        }



    }

    public void toppingsScreen(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Any toppings? (YES)/(NO)");
        String yesNoToppings = userInput.nextLine();

        switch(yesNoToppings.toUpperCase()){
            case "YES":
                addToppings(true);
                break;
            case "NO":
                System.out.println("No toppings, then.");
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void addToppings(boolean isEnabled){

        List<Toppings> toppingsList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        while(isEnabled) {
            System.out.println("How about toppings? Type the full name of the topping.");
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
                    TAKE ME TO THE NEXT SCREEN (SAUCE)
                    """);

            String toppingsInput = userInput.nextLine();

            switch (toppingsInput.toUpperCase()) {
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
                case "SAUCE":
                    if (toppingsList.isEmpty()) {
                        toppingsList = null;
                        isEnabled = false;
                        sauceScreen();
                        break;
                    }
                    isEnabled = false;
                    sauceScreen();
                    break;
                default:
                    System.out.println("Not an option");
            }

            currentIngredients.setToppings(toppingsList);

            System.out.println(currentIngredients.getToppings().toString() + " are currently ordered.");

            System.out.println("Do you want any more toppings? (YES)/(NO)");
            String yesNoToMultiple = userInput.nextLine();

            switch (yesNoToMultiple.toUpperCase()){
                case "YES":
                    System.out.println("Back to the toppings screen you go!");
                    continue;
                case "NO":
                    isEnabled = false;
                    sauceScreen();
                    break;
                default:
                    System.out.println("Not an option");
            }

        }

    }

    public void sauceScreen(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("And last but not least, any sauce? (YES)/(NO)");
        String yesNoSauce = userInput.nextLine();

        switch(yesNoSauce.toUpperCase()){
            case "YES":
                addSauce(true);
                break;
            case "NO":
                System.out.println("And plain it is.");
                sandwichConfirmationScreen();
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void addSauce(boolean isEnabled){

        List<Sauce> sauceList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

         while(isEnabled) {

             System.out.println("How about topping that off with some sauce? Type the full name of the sauce.");
             System.out.println("""
                     MAYO
                     MUSTARD
                     KETCHUP
                     RANCH
                     THOUSAND ISLAND
                     VINAIGRETTE
                     FINISH SANDWICH (FINISH)
                     """);

             String sauceInput = userInput.nextLine();

             switch (sauceInput.toUpperCase()) {
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
                 case "FINISH":
                     if (sauceList.isEmpty()) {
                         sauceList = null;
                         isEnabled = false;
                         sandwichConfirmationScreen();
                         break;
                     }
                     sandwichConfirmationScreen();
                     break;
                 default:
                     System.out.println("Not an option");
             }

             currentIngredients.setSauce(sauceList);

             System.out.println(currentIngredients.getSauce().toString() + " are currently ordered.");

             System.out.println("Do you want any more sauce? (YES)/(NO)");
             String yesNoToMultiple = userInput.nextLine();

             switch (yesNoToMultiple.toUpperCase()){
                 case "YES":
                     System.out.println("Back to the sauce screen you go!");
                     continue;
                 case "NO":
                     isEnabled = false;
                     sandwichConfirmationScreen();
                     break;
                 default:
                     System.out.println("Not an option");
             }


         }

        System.out.println("Do you want sauce on the side? (YES)/(NO)");
        String yesNoToMultiple = userInput.nextLine();

        switch (yesNoToMultiple.toUpperCase()){
            case "YES":
                System.out.println("Sauce on the side!");
            case "NO":
                System.out.println("Sauce on the sandwich it is!");
                sandwichConfirmationScreen();
                break;
            default:
                System.out.println("Not an option");
        }

    }

    public void sandwichConfirmationScreen(){

        System.out.println("And voila! Here's your sandwich. Adding it now...");

        BuildSandwich sandwichMaker = new BuildSandwich();
        Sandwich finishedSandwich = sandwichMaker.build(currentSandwich.getSize(), currentIngredients);
        currentOrder.setSandwich(finishedSandwich);

        System.out.println("And your sandwich is done!");

        orderScreen(true);

    }

    public void chipsScreen() {

        Scanner userInput = new Scanner(System.in);

        System.out.println("Some additional munchies with your order?");

        System.out.println("What chips do you want? Type in the full name of your chip flavor.");
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
                currentOrder.setChips(currentChips);
                break;
            case "BARBECUE":
                currentChips = Chips.BARBECUE;
                currentOrder.setChips(currentChips);
                break;
            case "SALT AND VINEGAR":
                currentChips = Chips.SALT_AND_VINEGAR;
                currentOrder.setChips(currentChips);
                break;
            case "JALAPENO":
                currentChips = Chips.JALAPENO;
                currentOrder.setChips(currentChips);
                break;
            case "ORDER":
                orderScreen(true);
                break;
            default:
                System.out.println("Not an option");
        }


    }

    public void drinkScreen() {

        currentDrink = new Drink();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Want to quench your thirst?");

        System.out.println("What size do you want your drink? Type in the full name of your drink size.");
        System.out.println("""
                SMALL
                MEDIUM
                LARGE
                GODZILLA
                CANCEL DRINK, BACK TO (ORDER)
                """);

        String drinkSizeInput = userInput.nextLine();

        switch(drinkSizeInput.toUpperCase()){
            case "SMALL":
                currentDrink.setDrinkSize(DrinkSize.SMALL);
                break;
            case "MEDIUM":
                currentDrink.setDrinkSize(DrinkSize.MEDIUM);
                break;
            case "LARGE":
                currentDrink.setDrinkSize(DrinkSize.LARGE);
                break;
            case "GODZILLA":
                currentDrink.setDrinkSize(DrinkSize.GODZILLA);
                break;
            case "ORDER":
                currentDrink = null;
                orderScreen(true);
                break;
            default:
                System.out.println("Not an option");

        }

        System.out.println("So, your drink size is: " + currentDrink.getDrinkSize().toString());

        System.out.println("Now, what kind of drink do you want? Type in the full name of your chosen drink type.");
        System.out.println("""
                COLA
                DR FIZZ
                ORANGE BLAST
                GRAPE BLAST
                STRAWBERRY BLAST
                WATER
                TEA
                LEMONADE
                RAMUNE
                """);

        String drinkTypeInput = userInput.nextLine();

        switch(drinkTypeInput.toUpperCase()){
            case "COLA":
                currentDrink.setDrinkType(DrinkList.COLA);
                break;
            case "DR FIZZ":
                currentDrink.setDrinkType(DrinkList.DR_FIZZ);
                break;
            case "ORANGE BLAST":
                currentDrink.setDrinkType(DrinkList.ORANGE_BLAST);
                break;
            case "GRAPE BLAST":
                currentDrink.setDrinkType(DrinkList.GRAPE_BLAST);
                break;
            case "STRAWBERRY BLAST":
                currentDrink.setDrinkType(DrinkList.STRAWBERRY_BLAST);
                break;
            case "WATER":
                currentDrink.setDrinkType(DrinkList.WATER);
                break;
            case "TEA":
                currentDrink.setDrinkType(DrinkList.TEA);
                break;
            case "LEMONADE":
                currentDrink.setDrinkType(DrinkList.LEMONADE);
                break;
            case "RAMUNE":
                currentDrink.setDrinkType(DrinkList.RAMUNE);
                break;
            default:
                System.out.println("Not an option");
        }

        System.out.println("So, the type of your drink is: " + currentDrink.getDrinkType());

        System.out.println("Lastly, ice or no ice? (YES)/(NO)");
        System.out.println("""
                ICE
                NO ICE
                """);

        String iceInput = userInput.nextLine();

        switch (iceInput.toUpperCase()){
            case "ICE":
                currentDrink.setHasIce(true);
                System.out.println("Your drink has ice now!");
                break;
            case "NO ICE":
                currentDrink.setHasIce(false);
                System.out.println("Your drink has no ice.");
                break;
            default:
                System.out.println("Not an option");
        }

        currentOrder.setDrink(currentDrink);

        orderScreen(true);
        
    }

    public void checkOutScreen() {

        if (currentSandwich != null){

            System.out.println("Here's your sandwich:");
            System.out.println(currentSandwich.toString());

        }

        if (currentDrink != null){

            System.out.println("Here's your drink:");
            System.out.println(currentDrink.toString());

        }

        if (currentChips != null){

            System.out.println("Here's your chips:");
            System.out.println("CHIP TYPE: " + currentChips.toString());

        }

        System.out.println("Here's your total:");

        currentOrder.getOrderPrice(currentSandwich, currentOrder);

        System.out.println("Confirm order? (YES)/(NO)");

        Scanner userInput = new Scanner(System.in);
        String confirmInput = userInput.nextLine();

        switch (confirmInput.toUpperCase()){
            case "YES":
                System.out.println("Confirming order...");
                break;
            case "NO":
                System.out.println("Deleting order...");
                currentOrder = null;
                currentSandwich = null;
                currentDrink = null;
                currentChips = null;
                orderScreen(true);
                break;
            default:
                System.out.println("Not an option");
        }

    }
}
