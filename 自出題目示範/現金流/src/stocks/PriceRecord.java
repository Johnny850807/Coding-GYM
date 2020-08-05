package stocks;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriceRecord implements StockLifecycle {
    private Stock stock;
    private LinkedList<Integer> records = new LinkedList<Integer>();

    public PriceRecord(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return records.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void newDay() {
        addNewRecord(stock.getPrice());
    }

    public void addNewRecord(int price) {
        records.add(price);
    }


}
