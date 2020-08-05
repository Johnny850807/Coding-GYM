package game;

import exception.CashFlowException;
import exception.NoStockException;
import players.Player;
import stocks.Order;
import stocks.StockMarket;
import stocks.StockProduct;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CashFlowGame implements Serializable {
    private final static int SELL_ACTION = 1;
    private final static int BUY_ACTION = 2;
    private final static int LEAVE_ACTION = 3;

    private CashFlowGameSaveManager saveManager;
    private Date gameDate;
    private StockMarket market;
    private List<Player> players = new ArrayList<>();
    private List<Player> rank = new ArrayList<>();
    private int turn = 0;

    public CashFlowGame(CashFlowGameSaveManager saveManager) {
        this.saveManager = saveManager;
    }

    private CashFlowGame configGame() {
        GameConfiguration config = new GameConfiguration();
        market = config.createMarket();
        players = config.createPlayers(market);
        return this;
    }

    public void start() throws InterruptedException, ClassNotFoundException, IOException {
        while (!isGameOver()) {
            runOneDay();
        }
        onGameOver();
    }

    private boolean isGameOver() {
        return players.stream()
                .allMatch(Player::isWin);
    }

    private void runOneDay() throws InterruptedException, ClassNotFoundException, IOException {
        turn = 0;
        while (turn < players.size()) {
            makeDecisions(players.get(turn));
            turn++;
        }
        market.newDay();
        saveManager.saveGame(this);
    }

    private void makeDecisions(Player player) throws InterruptedException {
        int choice;
        do {
            System.out.println(player.toString());
            System.out.println("請選擇 (1) 販賣股票 (2) 購買股票 (3) 結束回合 ");
            choice = player.makeDecision();
            effectDecision(player, choice);
            detectPlayerWins(player);
        } while (choice != 3 && !player.isWin());
    }

    private void effectDecision(Player player, int option) throws InterruptedException {
        try {
            Order order;
            switch (option) {
                case SELL_ACTION:
                    order = getPlayerSellOrder(player);
                    break;
                case BUY_ACTION:
                    order = getPlayerBuyOrder(player);
                    break;
                default: // LEAVE
                    return;
            }
            StockProduct product = market.executeOrder(order);
            player.receiveStockProduct(product);
        } catch (CashFlowException err) {
            System.err.println(err.getMessage());
            makeDecisions(player);
        }
    }

    private Order getPlayerSellOrder(Player player) {
        System.out.println(player.stocksToString());
        if (player.hasStocks())
            return player.chooseWhichStockToSell();
        throw new NoStockException();
    }

    private Order getPlayerBuyOrder(Player player) {
        market.display();
        return player.chooseWhichStockToBuy();
    }

    private void detectPlayerWins(Player player) {
        if (player.isWin()) {
            System.out.println(player.getName() + " 獲勝了 !");
            players.remove(player);
            rank.add(player);
        }
    }

    private void onGameOver() {
        saveManager.clearSave();
        printRankList();
    }

    public void printRankList() {

        for (int i = 0; i < rank.size(); i++)
            System.out.println("第" + (i + 1) + "名 : " + rank.get(i).getName());
    }

    private void delay() throws InterruptedException {
        Thread.sleep(0);
    }

    public static void main(String[] argv) {
        try {
            System.out.println("嗨");
            CashFlowGameSaveManager saveManager = new CashFlowGameSaveManager();
            if (saveManager.hasGameSave()) {
                saveManager.loadGame().start();
            }
            saveManager.startNewGame()
                    .configGame()
                    .start();
        } catch (InterruptedException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}

