package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao{

    public MySqlShoppingCartDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId){

        String query = "{CALL GetCartByUserId(?)}";

        ShoppingCart cart = new ShoppingCart();

        Map<Integer, ShoppingCartItem> itemsInCart = new HashMap<>();

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setInt(1, userId);

            ResultSet resultSet = callableStatement.executeQuery();

            while(resultSet.next()){

                int productId = resultSet.getInt("product_id");
                int productQuantity = resultSet.getInt("quantity");

                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                int category = resultSet.getInt("category_id");
                String desc = resultSet.getString("description");
                String color = resultSet.getString("color");
                int stock = resultSet.getInt("stock");
                boolean isFeatured = resultSet.getBoolean("featured");
                String url = resultSet.getString("image_url");

                Product product = new Product(productId, name, price, category, desc, color, stock, isFeatured, url);

                ShoppingCartItem item = new ShoppingCartItem();

                item.setProduct(product);
                item.setQuantity(productQuantity);
                item.setDiscountPercent(BigDecimal.ZERO);

                item.getLineTotal();

                itemsInCart.put(productQuantity, item);

                cart.setItems(itemsInCart);

                cart.getTotal();

            }

        }catch (SQLException ex){
            System.out.println("Sorry, couldn't get that cart by its user.");
        }

        return cart;
    }

    @Override
    public void addProductToCart(int userId, int productId){

        String query = "{CALL AddProductToCart(?, ?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, userId);
            callableStatement.setInt(2, productId);

            callableStatement.executeUpdate();

            System.out.println("Product successfully added to cart!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't add that item.");
        }

    }

    @Override
    public void updateQuantityOfItem(int productId, int quantity){

        String query = "{CALL UpdateQuantityOfItem(?, ?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, productId);
            callableStatement.setInt(2, quantity);

            callableStatement.executeUpdate();

            System.out.println("Item successfully updated!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't update this item.");
        }

    }

    @Override
    public void deleteCart(int userId){

        String query = "{CALL DeleteCart(?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, userId);

            callableStatement.executeUpdate();

            System.out.println("Successfully deleted cart!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't clear this cart.");
        }
    }
}
