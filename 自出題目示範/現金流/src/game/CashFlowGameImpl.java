package game;

import exception.NotYourTurnException;
import players.Player;
import stocks.StockMarket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CashFlowGameImpl implements CashFlowGame {
    private final Stack<GameCommand> gameCommandStack = new Stack<>();
    protected State state = State.UNREADY;
    protected StockMarket market = new StockMarket();
    protected final List<Player> allPlayers = new ArrayList<>(4);
    protected final List<Player> winners = new LinkedList<>();
    protected int currentTurn = -1;
    protected int currentDay = -1;

    public enum State {
        UNREADY, STARTED, GAME_OVER
    }

    @Override
    public int addPlayerAndGetId(Player player) {
        invokeCommand(new AddPlayerCommand(this, player));
        return player.getId();
    }

    @Override
    public void startGame() {
        invokeCommand(new StartGameCommand(this));
    }

    @Override
    public void buyStock(Player player, int stockId, int amount) {
        invokeCommand(new BuyStocksCommand(this, player, stockId, amount));
    }

    @Override
    public void sellStock(Player player, int stockId, int amount) {
        invokeCommand(new SellStocksCommand(this, player, stockId, amount));
    }

    @Override
    public void completeTurn(Player player) {
        invokeCommand(new CompleteTurnCommand(this, player));
    }

    public void populateSerializedCommand(GameCommand gameCommand) {
        if (gameCommand instanceof AbstractGameCommand) {
            ((AbstractGameCommand) gameCommand).setGame(this);
        }

        if (gameCommand instanceof AbstractPlayerGameCommand) {
            AbstractPlayerGameCommand playerGameCommand = (AbstractPlayerGameCommand) gameCommand;
            Player targetPlayer = allPlayers.stream()
                    .filter(p -> p.getId() == playerGameCommand.id)
                    .findFirst().orElseThrow(() -> new IllegalStateException("Player id not found, the command can't be populated."));
            playerGameCommand.setPlayer(targetPlayer);
        }
    }

    public void invokeCommand(GameCommand gameCommand) {
        gameCommand.execute();
        gameCommandStack.push(gameCommand);
    }

    public void undo() {
        if (gameCommandStack.isEmpty()) {
            throw new IllegalStateException("No commands.");
        } else {
            gameCommandStack.pop().undo();
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    @Override
    public int getCurrentDay() {
        return currentDay;
    }

    protected void newDay() {
        currentDay++;
        market.onDayEnds();
        market.onDayBegins();
    }

    @Override
    public boolean isGameOver() {
        return winners.size() == allPlayers.size();
    }

    @Override
    public StockMarket getMarket() {
        return market;
    }

    @Override
    public Player getCurrentPlayer() {
        return allPlayers.get(currentTurn);
    }

    @Override
    public List<Player> getWinnersInRank() {
        return winners;
    }

    public Stack<GameCommand> getGameCommandStack() {
        return gameCommandStack;
    }
}

abstract class AbstractGameCommand implements GameCommand {

    protected transient CashFlowGameImpl game;

    public AbstractGameCommand(CashFlowGameImpl game) {
        this.game = game;
    }

    protected void validateIsCurrentPlayer(Player player) {
        if (game.getCurrentPlayer() != player) {
            throw new NotYourTurnException();
        }
    }

    public void setGame(CashFlowGameImpl game) {
        this.game = game;
    }

}

abstract class AbstractPlayerGameCommand extends AbstractGameCommand {
    protected int id;
    protected transient Player player;

    public AbstractPlayerGameCommand(CashFlowGameImpl game, Player player) {
        super(game);
        setPlayer(player);
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.id = player.getId();
    }
}

class AddPlayerCommand extends AbstractGameCommand {

    private final Player player;

    public AddPlayerCommand(CashFlowGameImpl game, Player player) {
        super(game);
        this.player = player;
    }

    @Override
    public void execute() {
        if (game.state == CashFlowGameImpl.State.UNREADY) {
            player.setId(game.allPlayers.size() + 1);
            game.allPlayers.add(player);
        } else {
            throw new IllegalStateException("Can't add players during the " + game.state + " state.");
        }
    }

    @Override
    public void undo() {
        game.allPlayers.remove(player);
    }
}

class StartGameCommand extends AbstractGameCommand {
    private StockMarketSnapshot stockMarketSnapshot;

    StartGameCommand(CashFlowGameImpl game) {
        super(game);
    }

    @Override
    public void execute() {
        if (game.state == CashFlowGameImpl.State.GAME_OVER) {
            throw new IllegalStateException("The game has been over, cannot restart.");
        }
        game.state = CashFlowGameImpl.State.STARTED;
        game.currentTurn = 0;
        game.currentDay = 1;
        stockMarketSnapshot = new StockMarketSnapshot(game.market);
        game.market.onDayBegins();
    }

    @Override
    public void undo() {
        game.state = CashFlowGameImpl.State.UNREADY;
        game.currentDay = game.currentTurn = -1;
        stockMarketSnapshot.applyToMarket(game.market);
    }
}

/**
 * Since BuyStocksCommand is exactly the opposite of SellStocksCommand
 * we can just reuse BuyStocksCommand in the opposite way to implement SellStocksCommand
 */
class SellStocksCommand extends AbstractPlayerGameCommand {
    private final BuyStocksCommand buyStocksCommand;

    public SellStocksCommand(CashFlowGameImpl game, Player player, int stockId, int amount) {
        super(game, player);
        buyStocksCommand = new BuyStocksCommand(game, player, stockId, amount);
    }

    @Override
    public void execute() {
        buyStocksCommand.undo();
    }

    @Override
    public void undo() {
        buyStocksCommand.execute();
    }

    @Override
    public void setGame(CashFlowGameImpl game) {
        super.setGame(game);
        buyStocksCommand.setGame(game);
    }

    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);
        buyStocksCommand.setPlayer(player);
    }
}

class BuyStocksCommand extends AbstractPlayerGameCommand {
    private final int stockId, amount;

    public BuyStocksCommand(CashFlowGameImpl game, Player player, int stockId, int amount) {
        super(game, player);
        this.player = player;
        this.stockId = stockId;
        this.amount = amount;
    }

    @Override
    public void execute() {
        validateIsCurrentPlayer(player);
        Player currentPlayer = game.getCurrentPlayer();
        game.market.getAgent().buyStocks(currentPlayer, stockId, amount);
    }

    @Override
    public void undo() {
        validateIsCurrentPlayer(player);
        Player currentPlayer = game.getCurrentPlayer();
        game.market.getAgent().sellStocks(currentPlayer, stockId, amount);
    }
}

class CompleteTurnCommand extends AbstractPlayerGameCommand {
    private StockMarketSnapshot stockMarketSnapshot;
    private final boolean hasPlayerWon;
    private boolean isGameOver = false, isNewDay = false;
    private final int prevTurn, prevDay;

    public CompleteTurnCommand(CashFlowGameImpl game, Player player) {
        super(game, player);
        this.player = player;
        hasPlayerWon = this.player.isWin();
        prevTurn = game.currentTurn;
        prevDay = game.currentDay;
    }

    @Override
    public void execute() {
        validateIsCurrentPlayer(player);
        Player currentPlayer = game.getCurrentPlayer();
        if (currentPlayer.isWin()) {
            game.winners.add(currentPlayer);
        }
        if (game.isGameOver()) {
            isGameOver = true;
            game.state = CashFlowGameImpl.State.GAME_OVER;
        } else {
            game.currentTurn = findNextTurnIndex();
            if (game.currentTurn == 0) {
                isNewDay = true;
                stockMarketSnapshot = new StockMarketSnapshot(game.market);
                game.newDay();
            }
        }
    }

    @Override
    public void undo() {
        if (hasPlayerWon) {
            game.winners.remove(player);
        }
        if (isGameOver) {
            game.state = CashFlowGameImpl.State.STARTED;
        } else {
            game.currentTurn = prevTurn;
            if (isNewDay) {
                game.currentDay = prevDay;
                stockMarketSnapshot.applyToMarket(game.market);
            }
        }
    }

    private int findNextTurnIndex() {
        int index = game.currentTurn;
        do {
            index = (index + 1) % game.allPlayers.size();
        } while (game.allPlayers.get(index).isWin());
        return index;
    }
}