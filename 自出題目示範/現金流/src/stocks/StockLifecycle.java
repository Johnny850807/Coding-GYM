package stocks;

import java.io.Serializable;

public interface StockLifecycle extends Serializable {
    void onDayBegins();
    void onDayEnds();
}
