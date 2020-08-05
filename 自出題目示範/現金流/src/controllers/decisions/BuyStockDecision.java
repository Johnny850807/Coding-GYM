package controllers.decisions;

import controllers.CashflowGameController;
import players.Player;
import stocks.Stock;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class BuyStockDecision implements Decision {
    private final CashflowGameController controller;
    private final Player player;
    private Collection<Stock> stocks;
    private int stockId;
    private int amount;

    public BuyStockDecision(CashflowGameController controller, Player player, Collection<Stock> stocks) {
        this.controller = controller;
        this.player = player;
        this.stocks = stocks;
    }

    public Collection<Stock> getStocks() {
        return stocks;
    }

    public Collection<Integer> getAllStockIds() {
        return stocks.stream().map(Stock::getId)
                .collect(Collectors.toSet());
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean isAvailable() {
        return stocks.stream()
                .map(Stock::getCurrentPrice)
                .anyMatch(price -> price <= player.getMoney());
    }

    @Override
    public void perform() {
        controller.buyStock(player, stockId, amount);
    }
}
