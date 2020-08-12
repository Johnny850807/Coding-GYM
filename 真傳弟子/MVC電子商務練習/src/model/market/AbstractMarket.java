package model.market;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMarket implements Market {
    protected List<Product> products = new ArrayList<>();

    public AbstractMarket() {

    }

}
