package stocks.strategies;

import stocks.Stock;

import java.util.Random;

public class NormalPriceFluctuationStrategy implements PriceFluctuationStrategy {

    @Override
    public void changePrice(Stock stock) {
        Random random = new Random();
        int priceChange = random.nextInt(300) + 30;

        if (random.nextBoolean()) {
            priceChange *= -1;
        }

        int resultPrice = Math.max(stock.getCurrentPrice() + priceChange, 0);
        stock.setCurrentPrice(resultPrice);
    }

}
