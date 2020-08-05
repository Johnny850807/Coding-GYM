package stocks;

import stocks.strategies.PriceFluctuationStrategy;

import java.io.Serializable;

public class Stock implements Serializable, StockLifecycle {
    private PriceFluctuationStrategy priceFluctuationStrategy;
    private PriceRecord records;
    private int id;
    private String name;
    private int price;


    public Stock(int id, String name, int price, PriceFluctuationStrategy priceFluctuationStrategy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceFluctuationStrategy = priceFluctuationStrategy;
        records = new PriceRecord(this);
        records.addNewRecord(price);
    }

    @Override
    public void newDay() {
        priceFluctuationStrategy.changePrice(this);
        records.newDay();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s %d$ -> %s %n", id, name, price, records);
    }

}
