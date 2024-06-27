package org.yearup.data;

import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{
    ShoppingCart getByUserId(int userId);
    void addProductToCart(int userId, int productId);
    ShoppingCartItem updateQuantityOfItem(int productId, int quantity);
    void deleteCart(int userId);
}
