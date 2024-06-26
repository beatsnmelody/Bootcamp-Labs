package sandwichManager;

import java.util.Optional;

public class Sandwich {

    private Size size;
    private double sandwichPrice;
    private Ingredients ingredients;

    public Sandwich() {
    }

    public Sandwich(Size size, Ingredients ingredients) {
        this.size = size;
        this.ingredients = ingredients;
    }

    public Sandwich(Size size, double sandwichPrice, Ingredients ingredients) {
        this.size = size;
        this.sandwichPrice = sandwichPrice;
        this.ingredients = ingredients;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Optional<Ingredients> getIngredients() {
        return Optional.ofNullable(ingredients);
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public double calculateSandwichCost(Sandwich sandwich){

        sandwichPrice = 0;
        double breadPrice = 0;
        double meatPrice = 0;
        double cheesePrice = 0;
        boolean hasExtraMeat = sandwich.ingredients.isHasExtraMeat();
        boolean hasExtraCheese = sandwich.ingredients.isHasExtraCheese();

        if (sandwich.getSize().equals(Size.FOUR_INCH)){
            breadPrice += 5.50;
            meatPrice += 1.00;
            cheesePrice += .75;
        }else if (getSize().equals(Size.EIGHT_INCH)){
            breadPrice += 7.00;
            meatPrice += 2.00;
            cheesePrice += 1.50;
        }else if (getSize().equals(Size.TWELVE_INCH)){
            breadPrice += 8.50;
            meatPrice += 3.00;
            cheesePrice += 2.25;
        }

        if (hasExtraMeat && getSize().equals(Size.FOUR_INCH)){
            meatPrice += .50;
        }else if (hasExtraMeat && getSize().equals(Size.EIGHT_INCH)){
            meatPrice += 1.00;
        }else if (hasExtraMeat && getSize().equals(Size.TWELVE_INCH)){
            meatPrice += 1.50;
        }

        if (hasExtraCheese && getSize().equals(Size.FOUR_INCH)){
            cheesePrice += .30;
        }else if (hasExtraCheese && getSize().equals(Size.EIGHT_INCH)){
            cheesePrice += .60;
        }else if (hasExtraCheese && getSize().equals(Size.TWELVE_INCH)){
            cheesePrice += .90;
        }

        sandwichPrice = breadPrice + meatPrice + cheesePrice;

        return sandwichPrice;
    }

    @Override
    public String toString() {
        return "Sandwich: " +
                "\nSize: " + size +
                "\nSandwich Ingredients: " + getIngredients().orElse(new Ingredients()) +
                "\nTotal Cost Of Sandwich: " + sandwichPrice +
                '\n';
    }
}
