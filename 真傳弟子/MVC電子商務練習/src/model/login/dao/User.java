package model.login.dao;

import model.market.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String account;
    private String password;
    private int money = 5000;
    List<Product> heldProducts = new ArrayList<>();

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public List<Product> getHeldProducts() {
        return heldProducts;
    }

    public void addHeldProduct(Product product) {
        heldProducts.add(product);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void consumeMoney(int money) {
        setMoney(getMoney() - money);
    }
}
