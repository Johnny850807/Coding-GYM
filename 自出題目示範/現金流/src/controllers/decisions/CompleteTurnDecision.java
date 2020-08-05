package controllers.decisions;

import controllers.CashflowGameController;
import players.Player;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class CompleteTurnDecision implements Decision {
    private final CashflowGameController controller;
    private final Player player;

    public CompleteTurnDecision(CashflowGameController controller, Player player) {
        this.controller = controller;
        this.player = player;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void perform() {
        controller.completeTurn(player);
    }
}
