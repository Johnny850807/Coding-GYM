package stocks;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriceRecord implements StockLifecycle {
    private final Stock stock;
    private final LinkedList<Integer> records = new LinkedList<Integer>();

    public PriceRecord(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return records.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    @Override
    public void onDayBegins() {
        appendRecord(stock.getCurrentPrice());
    }

    @Override
    public void onDayEnds() {
    }

    private void appendRecord(int price) {
        records.add(price);
    }

}
