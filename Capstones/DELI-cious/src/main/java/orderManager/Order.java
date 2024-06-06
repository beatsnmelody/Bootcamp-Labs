package orderManager;

import sandwichManager.Sandwich;

import java.time.LocalDateTime;

public class Order {

    private Sandwich sandwich;
    private Drink drink;
    private Chips chips;
    private double orderPrice;
    private String customerName;
    private LocalDateTime dateTimeOrdered;

    public Order (){
        this.sandwich = null;
        this.drink = null;
        this.chips = null;
        this.orderPrice = 0;
        this.customerName = "";
        this.dateTimeOrdered = null;
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

    public Sandwich getSandwich() {
        return sandwich;
    }

    public Drink getDrink() {
        return drink;
    }

    public Chips getChips() {
        return chips;
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

    public double getOrderPrice(Order order){

        orderPrice = 0;
        double drinkPrice = 0;
        double chipsPrice = 0;
        double sandwichPrice = 0;
        boolean drinkOrdered = false;
        boolean sandwichOrdered = false;

        if (order.getDrink() != null){
            drinkOrdered = true;
        }

        if (drinkOrdered && order.drink.getDrinkSize().equals(DrinkSize.SMALL)){

            drinkPrice += 2.00;

        }else if(drinkOrdered && order.drink.getDrinkSize().equals(DrinkSize.MEDIUM)){

            drinkPrice += 2.50;

        }else if(drinkOrdered && order.drink.getDrinkSize().equals(DrinkSize.LARGE)){

            drinkPrice += 3.00;

        }else if(drinkOrdered && order.drink.getDrinkSize().equals(DrinkSize.GODZILLA)){

            drinkPrice += 3.50;

        }

        if (order.getChips() != null){
            chipsPrice += 1.50;
        }

        if (order.getSandwich() != null){
            sandwichOrdered = true;
        }

        if (sandwichOrdered){
            order.getSandwich().calculateSandwichCost(order.getSandwich());
        }

        orderPrice = sandwichPrice + drinkPrice + chipsPrice;

        return orderPrice;

    }

}
