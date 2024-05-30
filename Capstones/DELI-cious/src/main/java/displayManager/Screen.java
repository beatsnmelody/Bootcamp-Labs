package displayManager;

import orderManager.Order;
import sandwichManager.Bread;
import sandwichManager.Ingredients;
import sandwichManager.Meat;
import sandwichManager.Sandwich;

import java.util.ArrayList;
import java.util.List;
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
                    orderScreen(true);
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Not an option");

            }

        }

    }

    public void orderScreen(boolean isEnabled){

        while (isEnabled){

            Order currentOrder = new Order();

            System.out.println("What you want to add");

            Scanner userInput = new Scanner(System.in);

            int orderInput = Integer.parseInt(userInput.nextLine());

            switch(orderInput){
                case 1:
                    sandwichScreen(currentOrder);
                    break;
                case 2:
                    drinkScreen(currentOrder);
                    break;
                case 3:
                    chipsScreen(currentOrder);
                    break;
                case 4:
                    if (currentOrder.getSandwich() != null || currentOrder.getDrink() != null || currentOrder.getChips() != null){
                        checkOutScreen(currentOrder);
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

    public void sandwichScreen(Order currentOrder){

        Sandwich sandwich = new Sandwich();

        Ingredients ingredients = new Ingredients();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Bread?");
        System.out.println("""
                WHITE
                WHEAT
                RYE
                WRAP
                """);

        String breadInput = userInput.nextLine();

        switch(breadInput.toUpperCase()){
            case "WHITE":
                ingredients.setBread(Bread.WHITE);
                break;
            case "WHEAT":
                ingredients.setBread(Bread.WHEAT);
                break;
            case "RYE":
                ingredients.setBread(Bread.RYE);
                break;
            case "WRAP":
                ingredients.setBread(Bread.WRAP);
                break;
            default:
                System.out.println("Not an option");
        }

        List<Meat> meatList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {

            System.out.println("How about meat?");
            System.out.println("""
                    STEAK
                    HAM
                    SALAMI
                    ROAST BEEF
                    CHICKEN
                    BACON
                    NONE
                    """);

            String meatInput = userInput.nextLine();

            switch (meatInput.toUpperCase()) {
                case "STEAK":
                    assert meatList != null;
                    meatList.add(Meat.STEAK);
                    break;
                case "HAM":
                    assert meatList != null;
                    meatList.add(Meat.HAM);
                    break;
                case "SALAMI":
                    assert meatList != null;
                    meatList.add(Meat.SALAMI);
                    break;
                case "ROAST BEEF":
                    assert meatList != null;
                    meatList.add(Meat.ROAST_BEEF);
                    break;
                case "CHICKEN":
                    assert meatList != null;
                    meatList.add(Meat.CHICKEN);
                    break;
                case "BACON":
                    assert meatList != null;
                    meatList.add(Meat.BACON);
                    break;
                case "NONE":
                    meatList = null;
                    i = 4;
                    break;
                default:
                    System.out.println("Not an option");
            }

            ingredients.setMeat(meatList);

        }

        List<Meat> cheeseList = new ArrayList<>();

    }

    public void drinkScreen(Order currentOrder){
        System.out.println("Hi lol");
    }

    public void chipsScreen(Order currentOrder){
        System.out.println("Hi lol");
    }

    public void checkOutScreen(Order currentOrder){
        System.out.println("Hi lol");
    }

}
