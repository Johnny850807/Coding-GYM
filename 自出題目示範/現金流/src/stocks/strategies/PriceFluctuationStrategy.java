package stocks.strategies;

import stocks.Stock;

import java.io.Serializable;

public interface PriceFluctuationStrategy extends Serializable {
    public void changePrice(Stock stock);
}
