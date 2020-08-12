package model;

import model.login.LoginSystem;
import model.market.Market;
import model.market.Product;

import java.util.List;

public class StandardEcommerceSystem extends AbstractEcommerceSystem {

    public StandardEcommerceSystem(LoginSystem loginSystem, Market market) {
        super(loginSystem, market);
    }

    @Override
    public boolean login(String account, String password) throws Exception {
        setUser(loginSystem.login(account, password));

        return false;
    }

    @Override
    public void register(String account, String password) throws Exception {
        loginSystem.register(account, password);

    }

    @Override
    public void buyProducts(int select, int amount) throws Exception {
        List<Product> buyProducts = market.buyProduct(select, amount, user.getMoney());
        user.getHeldProducts().addAll(buyProducts);

        user.consumeMoney(buyProducts.get(select).getMoney() * amount);

    }

    @Override
    public void signOut() {
        loginSystem.signOut();
        user = null;

    }

    @Override
    public List<Product> getUserAllProducts() {
        return user.getHeldProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return market.getAllProducts();
    }
}
