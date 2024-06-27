package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
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

            ResultSet resultSet = callableStatement.executeQuery();

            while(resultSet.next()){

                int product = resultSet.getInt("product_id");
                int productQuantity = resultSet.getInt("quantity");

                ShoppingCartItem item = cart.get(product);

                itemsInCart.put(productQuantity, item);

                cart.setItems(itemsInCart);

            }

        }catch (SQLException ex){
            System.out.println("Sorry, couldn't get that cart by its user.");
        }

        return cart;
    }

    @Override
    public void addProductToCart(int productId, Product product){

        String query = "{CALL AddProductToCart(?)}";

        try(Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query)){

            callableStatement.setInt(1, productId);

            callableStatement.executeUpdate();

            System.out.println("Product successfully added to cart!");

        }
        catch (SQLException ex){
            System.out.println("Couldn't add that item.");
        }

    }

    public ShoppingCartItem updateQuantityOfItem(int productId, int quantity){
        return null;
    }

    public void deleteCart(int userId){

    }
}
