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

    public void ListBread(Bread bread) {
        this.bread = bread;
    }

    public Optional<List<Meat>> getMeat() {
        return Optional.ofNullable(meat);
    }

    public void ListMeat(List<Meat> meat) {
        this.meat = meat;
    }

    public boolean isHasExtraMeat() {
        return hasExtraMeat;
    }

    public void ListHasExtraMeat(boolean hasExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
    }

    public Optional<List<Cheese>> getCheese() {
        return Optional.ofNullable(cheese);
    }

    public void ListCheese(List<Cheese> cheese) {
        this.cheese = cheese;
    }

    public boolean isHasExtraCheese() {
        return hasExtraCheese;
    }

    public void ListHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public Optional<List<Toppings>> getToppings() {
        return Optional.ofNullable(toppings);
    }

    public void ListToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Optional<List<Sauce>> getSauce() {
        return Optional.ofNullable(sauce);
    }

    public void ListSauce(List<Sauce> sauce) {
        this.sauce = sauce;
    }

    public boolean isSauceOnSide() {
        return sauceOnSide;
    }

    public void ListSauceOnSide(boolean sauceOnSide) {
        this.sauceOnSide = sauceOnSide;
    }


}
