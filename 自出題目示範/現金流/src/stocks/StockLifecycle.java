package stocks;

import java.io.Serializable;

public interface StockLifecycle extends Serializable {
    void display();
    void newDay();
}
