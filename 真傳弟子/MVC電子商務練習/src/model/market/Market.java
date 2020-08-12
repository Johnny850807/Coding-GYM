package model.market;

import java.util.List;

public interface Market {
    List<Product> buyProduct(int select, int amount, int money) throws Exception;

    List<Product> getAllProducts();
}
