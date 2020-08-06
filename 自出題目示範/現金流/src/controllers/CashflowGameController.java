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

        void onSavingGame();

        void onGameSaved();

        Decision onMakeDecision(BuyStockDecision buyStockDecision,
                                SellStockDecision sellStockDecision,
                                CompleteTurnDecision completeTurnDecision);

        void onGameOver(List<Player> winnersInRank);
    }

    public interface PlayerListener extends Listener {
        void onAskingPlayerName(Consumer<String> nameConsumer);
    }

    public CashflowGameController(CashFlowGame game) {
        this.game = game;
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }


    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void startGame() {
        askForPlayerNames();
        game.startGame();
        currentDay = game.getCurrentDay();
        notifyAllListeners(Listener::onGameStarted);
        notifyAllListeners(Listener::onDayBegins);
    }

    private void askForPlayerNames() {
        listeners.stream()
                .filter(l -> l instanceof PlayerListener)
                .map(l -> (PlayerListener) l)
                .forEach(this::askForPlayerName);
    }

    private void askForPlayerName(PlayerListener playerListener) {
        playerListener.onAskingPlayerName(name -> {
            int playerId = game.addPlayerAndGetId(new Player(name));
            playerListenerMap.put(playerId, playerListener);
        });
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
