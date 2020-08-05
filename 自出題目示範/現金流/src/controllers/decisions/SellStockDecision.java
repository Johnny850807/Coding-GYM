package controllers.decisions;

import controllers.CashflowGameController;
import players.OwnStock;
import players.Player;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class SellStockDecision implements Decision {
    private final CashflowGameController controller;
    private final Player player;
    private Collection<OwnStock> ownStocks;
    private int stockId;
    private int amount;

    public SellStockDecision(CashflowGameController controller, Player player, Collection<OwnStock> ownStocks) {
        this.controller = controller;
        this.player = player;
        this.ownStocks = ownStocks;
    }

    public Collection<OwnStock> getOwnStocks() {
        return ownStocks;
    }

    public Collection<Integer> getAllOwnStockIds() {
        return ownStocks.stream().map(OwnStock::getId)
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
        return !ownStocks.isEmpty();
    }

    @Override
    public void perform() {
        controller.sellStock(player, stockId, amount);
    }
}
