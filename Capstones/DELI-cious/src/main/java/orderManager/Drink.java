package orderManager;

public class Drink {

    private DrinkSize drinkSize;
    private DrinkList drinkType;
    private boolean hasIce;

    public Drink(){
    }

    public Drink(DrinkSize drinkSize, DrinkList drinkType, boolean hasIce) {
        this.drinkSize = drinkSize;
        this.drinkType = drinkType;
        this.hasIce = hasIce;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkList getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkList drinkType) {
        this.drinkType = drinkType;
    }

    public boolean isHasIce() {
        return hasIce;
    }

    public void setHasIce(boolean hasIce) {
        this.hasIce = hasIce;
    }

    @Override
    public String toString() {
        return "Drink: " +
                "Drink Size: " + drinkSize +
                "\nDrink Type: " + drinkType +
                "\nHas Ice: " + hasIce +
                '\n';
    }
}
