package sandwichManager;

import java.util.Optional;
import java.util.List;

public class Ingredients {

    private Bread bread;

    private List<Meat> meat;
    private boolean hasExtraMeat;

    private List<Cheese> cheese;
    private boolean hasExtraCheese;

    private List<Toppings> toppings;

    private List<Sauce> sauce;
    private boolean sauceOnSide;

    public Ingredients() {
    }

    public Ingredients(Bread bread) {
        this.bread = bread;
    }

    public Ingredients(Bread bread, List<Meat> meat, boolean hasExtraMeat, List<Cheese> cheese, boolean hasExtraCheese, List<Toppings> toppings, List<Sauce> sauce, boolean sauceOnSide) {
        this.bread = bread;
        this.meat = meat;
        this.hasExtraMeat = hasExtraMeat;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.toppings = toppings;
        this.sauce = sauce;
        this.sauceOnSide = sauceOnSide;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Optional<List<Meat>> getMeat() {
        return Optional.ofNullable(meat);
    }

    public void setMeat(List<Meat> meat) {
        this.meat = meat;
    }

    public boolean isHasExtraMeat() {
        return hasExtraMeat;
    }

    public void setHasExtraMeat(boolean hasExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
    }

    public Optional<List<Cheese>> getCheese() {
        return Optional.ofNullable(cheese);
    }

    public void setCheese(List<Cheese> cheese) {
        this.cheese = cheese;
    }

    public boolean isHasExtraCheese() {
        return hasExtraCheese;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public Optional<List<Toppings>> getToppings() {
        return Optional.ofNullable(toppings);
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Optional<List<Sauce>> getSauce() {
        return Optional.ofNullable(sauce);
    }

    public void setSauce(List<Sauce> sauce) {
        this.sauce = sauce;
    }

    public boolean isSauceOnSide() {
        return sauceOnSide;
    }

    public void setSauceOnSide(boolean sauceOnSide) {
        this.sauceOnSide = sauceOnSide;
    }

    @Override
    public String toString() {
        return "Ingredients: " +
                "\nBread: " + bread +
                "\nMeat: " + meat +
                "\nExtra Meat: " + hasExtraMeat +
                "\nCheese: " + cheese +
                "\nExtra Cheese: " + hasExtraCheese +
                "\nToppings: " + toppings +
                "\nSauce:" + sauce +
                "\nSauce On Side: " + sauceOnSide +
                '\n';
    }
}
