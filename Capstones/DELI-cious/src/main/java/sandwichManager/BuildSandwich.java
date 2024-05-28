package sandwichManager;

public class BuildSandwich implements SandwichBuilder{

    private Size size;
    private Ingredients ingredients;

    public Size getSize() {
        return size;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public BuildSandwich setSize(Size size){
        this.size = size;
        return this;
    }

    public BuildSandwich setIngredients(Ingredients ingredients){
        this.ingredients = ingredients;
        return this;
    }


    public Sandwich build(Size size, Ingredients ingredients){
        return new Sandwich(size, ingredients);
    }

}
