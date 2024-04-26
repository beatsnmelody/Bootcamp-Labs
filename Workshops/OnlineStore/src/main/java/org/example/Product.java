package org.example;

//Products have five properties
//SKU, Product Name, Price, Category, Description
//one constructor for all 5 properties
//getters and setters for each property

//Department Brainstorming
//"Trivial Little Knickknacks"
//"Useful Utility Thingamajigs"
//"Novelties For Infinite Fun"
//"Music To Thy Ears"
//"The Latest Gadgets"
//"Wonders Of The World"
public class Product {

    private int SKU;
    private String name;
    private double price;
    private String category;
    private String description;

    public Product(int SKU, String name, double price, String category, String description) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public int getSKU() {
        return SKU;
    }

    public void setSKU(int SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
