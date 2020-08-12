package model;

import model.market.Product;

import java.util.List;

public interface EcommerceSystem {
    boolean login(String account, String password) throws Exception;

    void register(String account, String password) throws Exception;

    void buyProducts(int select, int amount) throws Exception;

    void signOut();

    List<Product> getUserAllProducts();

    List<Product> getAllProducts();

}
