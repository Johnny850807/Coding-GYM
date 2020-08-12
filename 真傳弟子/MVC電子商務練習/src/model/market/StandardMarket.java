package model.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exception.*;

public class StandardMarket extends AbstractMarket {
    List<Product> products = new ArrayList<>();

    public StandardMarket() {
        products.add(new StandardProduct("玉米", 30));
        products.add(new StandardProduct("蓮霧", 40));
        products.add(new StandardProduct("芭樂", 25));
        products.add(new StandardProduct("西瓜", 45));
    }

    @Override
    public List<Product> buyProduct(int select, int amount, int money) throws Exception {
        checkSelectIsInRange(select);
        int productMoney = products.get(select).getMoney();

        if (checkMoneyIsEnough(productMoney * amount, money)) {
            List<Product> buyProducts = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                buyProducts.add(products.get(select));
            }
            return buyProducts;
        }

        return Collections.emptyList();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    public boolean checkMoneyIsEnough(int buyMoney, int userMoney) throws Exception {
        if (userMoney < buyMoney) {
            throw new MoneyIsNotEnoughException();
        }
        return true;
    }

    public boolean checkSelectIsInRange(int select) throws SelectProductsExceedOptionException {
        if (select > products.size()) {
            throw new SelectProductsExceedOptionException();
        }
        return true;
    }
}
