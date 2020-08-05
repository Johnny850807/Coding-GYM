package game;

import players.Player;
import stocks.StockMarket;

import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface CashFlowGame {
    int addPlayerAndGetId(Player player);

    List<Player> getAllPlayers();

    int getCurrentDay();

    void startGame();

    void buyStock(Player player, int stockId, int amount);

    void sellStock(Player player, int stockId, int amount);

    void completeTurn(Player player);

    boolean isGameOver();

    StockMarket getMarket();

    Player getCurrentPlayer();

    List<Player> getWinnersInRank();
}
