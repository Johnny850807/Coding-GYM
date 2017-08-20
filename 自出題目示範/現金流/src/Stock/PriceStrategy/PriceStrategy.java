package Stock.PriceStrategy;

import java.io.Serializable;

import Stock.Stock;

public interface PriceStrategy extends Serializable{
	public void changePrice(Stock stock);
}
