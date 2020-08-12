package main;

import controller.EcommerceController;
import controller.StandardEcommerceController;
import model.EcommerceSystem;
import model.StandardEcommerceSystem;
import model.login.LoginSystem;
import model.login.StandardLoginSystem;
import model.login.dao.UserRepository;
import model.login.dao.JsonUserRepository;
import model.market.Market;
import model.market.StandardMarket;
import view.StandardView;
import view.View;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new JsonUserRepository();
        LoginSystem loginSystem = new StandardLoginSystem(userRepository);
        Market market = new StandardMarket();
        EcommerceSystem ecommerceSystem = new StandardEcommerceSystem(loginSystem, market);
        EcommerceController ecommerceController = new StandardEcommerceController(ecommerceSystem);
        View view = new StandardView(ecommerceController);
        ecommerceController.setView(view);
        view.launch();

    }
}