package ai;

import controllers.CashflowGameController;
import controllers.decisions.BuyStockDecision;
import controllers.decisions.CompleteTurnDecision;
import controllers.decisions.Decision;
import controllers.decisions.SellStockDecision;
import players.Player;

import java.util.List;

/**
 * TODO
 * @author johnny850807@gmail.com (Waterball))
 */
public class AI implements CashflowGameController.Listener {
    @Override
    public void onGameStarted() {
        // I don't care
    }

    @Override
    public void onPlayerTurn(Player player) {
        // I don't care
    }

    @Override
    public Decision onMakeDecision(BuyStockDecision buyStockDecision, SellStockDecision sellStockDecision, CompleteTurnDecision completeTurnDecision) {
        return completeTurnDecision;
    }

    @Override
    public void onGameOver(List<Player> winnersInRank) {
        // I don't care
    }

    @Override
    public void onDayBegins() {
        // I don't care
    }

    @Override
    public void onDayEnds() {
        // I don't care
    }
}
