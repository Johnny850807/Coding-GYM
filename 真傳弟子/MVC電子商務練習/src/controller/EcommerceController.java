package controller;

import view.View;

public interface EcommerceController {
    void login(String account, String password);

    void register(String account, String password);

    void displayOwnProducts();

    void buyProducts(int select, int amount);

    void setView(View view);

    void displayAllProducts();

    void signOut();
}
