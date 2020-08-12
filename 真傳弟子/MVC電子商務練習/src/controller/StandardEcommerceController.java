package controller;

import model.EcommerceSystem;
import model.market.Product;
import view.View;
import view.status.EcommerceState;

import java.util.List;

public class StandardEcommerceController extends AbstractEcommerceController {

    public StandardEcommerceController(EcommerceSystem ecommerceSystem) {
        super(ecommerceSystem);
    }

    @Override
    public void login(String account, String password) {
        executor.execute(() -> {
            try {
                ecommerceSystem.login(account, password);
                view.loginSuccessful();

            } catch (Exception e) {
                view.onError(e);
            }
        });
    }

    @Override
    public void register(String account, String password) {
        executor.execute(() -> {
            try {
                ecommerceSystem.register(account, password);
                view.onUpdate("註冊成功");

            } catch (Exception e) {
                view.onError(e);
            }
        });
    }

    @Override
    public void displayOwnProducts() {
        List<Product> userHeldProducts = ecommerceSystem.getUserAllProducts();

        if (userHeldProducts.isEmpty()) {
            view.onUpdate("無");
        }

        for (int i = 1; i <= userHeldProducts.size(); i++) {
            view.onUpdate(" ( " + i + " ) " + userHeldProducts.get(i - 1).getName());
        }
    }

    @Override
    public void buyProducts(int number, int amount) {
        executor.execute(() -> {
            try {
                displayAllProducts();
                ecommerceSystem.buyProducts(number, amount);
                view.onUpdate("購買成功");

            } catch (Exception e) {
                view.onError(e);
            }
        });
    }

    @Override
    public void displayAllProducts() {
        List<Product> products = ecommerceSystem.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            view.onUpdate(" ( " + i + " ) " + products.get(i).toString());
        }
    }

    @Override
    public void signOut() {
        ecommerceSystem.signOut();
        view.onUpdate("登出成功");
    }

    @Override
    public void setView(View view) {
        super.view = view;
    }
}
