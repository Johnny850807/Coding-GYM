package controller;

import model.EcommerceSystem;
import view.View;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class AbstractEcommerceController implements EcommerceController {
    protected EcommerceSystem ecommerceSystem;
    protected Executor executor = Executors.newFixedThreadPool(4);
    protected View view;

    public AbstractEcommerceController(EcommerceSystem ecommerceSystem) {
        this.ecommerceSystem = ecommerceSystem;
    }
}
