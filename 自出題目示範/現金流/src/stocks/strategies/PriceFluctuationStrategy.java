package stocks.strategies;

import stocks.Stock;
import stocks.StockLifecycle;

import java.io.Serializable;

public interface PriceFluctuationStrategy extends StockLifecycle {
    void setStock(Stock stock);
}
