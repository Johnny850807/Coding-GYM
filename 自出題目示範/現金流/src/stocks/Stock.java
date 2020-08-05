package stocks;

import stocks.strategies.PriceFluctuationStrategy;

public class Stock implements StockLifecycle {
    private final PriceFluctuationStrategy priceFluctuationStrategy;
    private final PriceRecord records;
    private int id;
    private String name;
    private int currentPrice;


    public Stock(int id, String name, int currentPrice, PriceFluctuationStrategy priceFluctuationStrategy) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.priceFluctuationStrategy = priceFluctuationStrategy;
        priceFluctuationStrategy.setStock(this);
        records = new PriceRecord(this);
    }

    @Override
    public void onDayBegins() {
        priceFluctuationStrategy.onDayBegins();
        records.onDayBegins();
    }

    @Override
    public void onDayEnds() {
        priceFluctuationStrategy.onDayEnds();
        records.onDayEnds();
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

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s %d$ -> %s %n", id, name, currentPrice, records);
    }

}
