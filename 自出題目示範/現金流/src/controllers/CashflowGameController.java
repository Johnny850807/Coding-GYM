package controllers;

import controllers.decisions.BuyStockDecision;
import controllers.decisions.CompleteTurnDecision;
import controllers.decisions.Decision;
import controllers.decisions.SellStockDecision;
import game.CashFlowGame;
import players.Player;
import stocks.StockLifecycle;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class CashflowGameController {
    private final Collection<Listener> listeners = new LinkedList<>();
    // <Player's id, listener>
    private final Map<Integer, Listener> playerListenerMap = new HashMap<>();
    private final CashFlowGame game;
    private int currentDay;

    public interface Listener extends StockLifecycle {
        void onGameStarted();

        void onPlayerTurn(Player player);

        Decision onMakeDecision(BuyStockDecision buyStockDecision,
                                SellStockDecision sellStockDecision,
                                CompleteTurnDecision completeTurnDecision);

        void onGameOver(List<Player> winnersInRank);
    }

    public CashflowGameController(CashFlowGame game) {
        this.game = game;
    }

    public void addPlayerListener(int playerId, Listener listener) {
        playerListenerMap.put(playerId, listener);
        addListener(listener);
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void startGame() {
        game.startGame();
        currentDay = game.getCurrentDay();
        notifyAllListeners(Listener::onGameStarted);
        notifyAllListeners(Listener::onDayBegins);
    }

    public void buyStock(Player player, int stockId, int amount) {
        game.buyStock(player, stockId, amount);
    }

    public void sellStock(Player player, int stockId, int amount) {
        game.sellStock(player, stockId, amount);
    }

    public void completeTurn(Player player) {
        game.completeTurn(player);
        notifyNextTurn();
        notifyIfNewDay();
        notifyIfGameOver();
    }

    private void notifyNextTurn() {
        Player currentPlayer = game.getCurrentPlayer();

        notifyAllListeners(listener -> listener.onPlayerTurn(currentPlayer));

        listeners.stream()
                .filter(listener -> listener == playerListenerMap.get(currentPlayer.getId()))
                .findFirst()
                .map(listener ->
                        listener.onMakeDecision(new BuyStockDecision(this, currentPlayer,  game.getMarket().getStocks()),
                                new SellStockDecision(this, currentPlayer, currentPlayer.getOwnStocks()),
                                new CompleteTurnDecision(this, currentPlayer)))
                .ifPresent(Decision::perform);
    }

    private void notifyIfNewDay() {
        if (currentDay != game.getCurrentDay()) {
            notifyAllListeners(Listener::onDayEnds);
            notifyAllListeners(Listener::onDayBegins);
        }
    }

    private void notifyIfGameOver() {
        if (game.isGameOver()) {
            notifyAllListeners(listener -> listener.onGameOver(game.getWinnersInRank()));
        }
    }

    private void notifyAllListeners(Consumer<Listener> listenerConsumer) {
        listeners.forEach(listenerConsumer);
    }

}
