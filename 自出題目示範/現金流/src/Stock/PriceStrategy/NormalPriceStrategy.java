package Stock.PriceStrategy;

import java.util.Random;

import Stock.Stock;

public class NormalPriceStrategy implements PriceStrategy{

	@Override
	public void changePrice(Stock stock) {
		Random random = new Random();
		int priceChange = random.nextInt(300)+30;

		if (random.nextBoolean())
			priceChange *= -1;
		
		int resultPrice = stock.getPrice() + priceChange <= 0 ? 0 : stock.getPrice() + priceChange;
		stock.setPrice(resultPrice);
	}

}
