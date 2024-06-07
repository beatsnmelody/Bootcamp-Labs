package orderManager;

import sandwichManager.Sandwich;

import java.time.LocalDateTime;
import java.util.Optional;

public class Order {

    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;
    private double orderPrice;
    private String customerName;
    private LocalDateTime dateTimeOrdered;

    public Order (){

    }

    public Order(Sandwich sandwich, Drink drink, Chips chips, double orderPrice, String customerName, LocalDateTime dateTimeOrdered) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.chips = chips;
        this.orderPrice = orderPrice;
        this.customerName = customerName;
        this.dateTimeOrdered = dateTimeOrdered;
    }

    public Order(Sandwich sandwich, double orderPrice, String customerName, LocalDateTime dateTimeOrdered) {
        this.sandwich = sandwich;
        this.orderPrice = orderPrice;
        this.customerName = customerName;
        this.dateTimeOrdered = dateTimeOrdered;
    }

    public Order(Drink drink, double orderPrice, String customerName, LocalDateTime dateTimeOrdered) {
        this.drink = drink;
        this.orderPrice = orderPrice;
        this.customerName = customerName;
        this.dateTimeOrdered = dateTimeOrdered;
    }

    public Order(Chips chips, double orderPrice, String customerName, LocalDateTime dateTimeOrdered) {
        this.chips = chips;
        this.orderPrice = orderPrice;
        this.customerName = customerName;
        this.dateTimeOrdered = dateTimeOrdered;
    }

    public Order(Sandwich sandwich, Drink drink, Chips chips) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.chips = chips;
    }

    public Order(Sandwich sandwich, Drink drink) {
        this.sandwich = sandwich;
        this.drink = drink;
    }

    public Order(Drink drink, Chips chips) {
        this.drink = drink;
        this.chips = chips;
    }

    public Order(Chips chips, Sandwich sandwich) {
        this.chips = chips;
        this.sandwich = sandwich;
    }

    public Order(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Order(Drink drink) {
        this.drink = drink;
    }

    public Order(Chips chips) {
        this.chips = chips;
    }

    public Optional<Sandwich> getSandwich() {
        return Optional.ofNullable(sandwich);
    }

    public Optional<Drink> getDrink() {
        return Optional.ofNullable(drink);
    }

    public Optional<Chips> getChips() {
        return Optional.ofNullable(chips);
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getDateTimeOrdered() {
        return dateTimeOrdered;
    }

    public void setDateTimeOrdered(LocalDateTime dateTimeOrdered) {
        this.dateTimeOrdered = dateTimeOrdered;
    }

    public double getOrderPrice(Sandwich sandwich, Order order, Drink currentdrink, Chips currentchips){

        orderPrice = 0;
        double drinkPrice = 0;
        double chipsPrice = 0;
        double sandwichPrice = 0;
        boolean drinkOrdered = false;
        boolean sandwichOrdered = false;

        if (order.getDrink().isPresent()){
            drinkOrdered = true;
        }

        if (drinkOrdered && currentdrink.getDrinkSize().equals(DrinkSize.SMALL)){

            drinkPrice += 2.00;

        }else if(drinkOrdered && currentdrink.getDrinkSize().equals(DrinkSize.MEDIUM)){

            drinkPrice += 2.50;

        }else if(drinkOrdered && currentdrink.getDrinkSize().equals(DrinkSize.LARGE)){

            drinkPrice += 3.00;

        }else if(drinkOrdered && currentdrink.getDrinkSize().equals(DrinkSize.GODZILLA)){

            drinkPrice += 3.50;

        }

        if (order.getChips().isPresent()){
            chipsPrice += 1.50;
        }

        if (order.getSandwich().isPresent()){
            sandwichOrdered = true;
        }

        if (sandwichOrdered){
           sandwichPrice = sandwich.calculateSandwichCost(sandwich);
        }

        orderPrice = sandwichPrice + drinkPrice + chipsPrice;

        return orderPrice;

    }

    @Override
    public String toString() {
        return "DELI-licious Receipt: " +
                "\nSandwich: " + sandwich.toString() +
                "\nDrink: " + drink.toString() +
                "\nChips: " + chips.toString() +
                "\nTotal Cost: " + orderPrice +
                '\n';
    }
}
