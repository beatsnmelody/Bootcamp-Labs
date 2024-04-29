package org.example;

//the purpose of this class is to read and potentially write files
//namely, reading the products from the products.csv file
//and writing receipts when the user finishes checking out
//maybe if I have time...maybe I can have an employee view feature to add/remove products?

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileManager {

    public static List<Product> getProducts(){

        List<Product> products = new ArrayList<>();

        String filePath = "src/main/resources/products.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String productLine;
            while((productLine = reader.readLine()) != null){

                String[] productData = productLine.split("\\|");
                int SKU = Integer.parseInt(productData[0]);
                String name = productData[1];
                double price = Double.parseDouble(productData[2].replace(",", ""));
                String category = productData[3];
                String description = productData[4];

                Product product = new Product(SKU, name, price, category, description);
                products.add(product);

            }

        }catch(IOException ex){
            System.out.println("{OOPS...I CAN'T GET THIS LIST OF PRODUCTS.}");
        }

        for(Product product : products){
            System.out.printf("SKU: %d Name: %s \nPrice $%.2f Category: %s \nDescription: %s \n~~~~~~~~~~~~~~~~~~~~~~~~~\n", product.getSKU(), product.getName(), product.getPrice(), product.getCategory(), product.getDescription());
        }

        return products;

    }

}
