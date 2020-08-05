package controllers;

import controllers.decisions.BuyStockDecision;
import controllers.decisions.CompleteTurnDecision;
import controllers.decisions.Decision;
import controllers.decisions.SellStockDecision;
import game.CashFlowGameImpl;
import game.GameCommand;
import players.Player;

import java.io.*;
import java.util.List;
import java.util.Stack;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class GameRecorder implements CashflowGameController.Listener {
    private String filePath;
    private CashFlowGameImpl cashFlowGame;

    public GameRecorder(String filePath, CashFlowGameImpl cashFlowGame) {
        this.filePath = filePath;
        this.cashFlowGame = cashFlowGame;
    }

    @Override
    public void onGameStarted() {
        saveCommands();
    }

    @Override
    public void onPlayerTurn(Player player) {
        saveCommands();
    }

    @Override
    public Decision onMakeDecision(BuyStockDecision buyStockDecision, SellStockDecision sellStockDecision, CompleteTurnDecision completeTurnDecision) {
       throw new UnsupportedOperationException("Shouldn't be invoked.");
    }

    @Override
    public void onGameOver(List<Player> winnersInRank) { }

    @Override
    public void onDayBegins() { }

    @Override
    public void onDayEnds() { }

    private synchronized void saveCommands() {
        Stack<GameCommand> gameCommandStack = cashFlowGame.getGameCommandStack();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(gameCommandStack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static LoadGame loadGame(String filePath) {
        CashFlowGameImpl game = new CashFlowGameImpl();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))){
            Stack<GameCommand> serializedGameCommandStack = (Stack<GameCommand>) in.readObject();
            for (GameCommand command : serializedGameCommandStack) {
                game.populateSerializedCommand(command);
                game.invokeCommand(command);
            }
            return new LoadGame();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static class LoadGame {
        public int playerId;
        public CashFlowGameImpl game;

        public LoadGame(int playerId, CashFlowGameImpl game) {
            this.playerId = playerId;
            this.game = game;
        }
    }
}
