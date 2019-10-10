package GameSystem;

import GamePlayer.*;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class GuessPasswordGameSystem extends GuessPasswordGameTemplate {

    protected List<Player> gamePlayerList;
    int belowNumber, topNumber, password, playerGuessPassword;

    public static void main(String[] args) {
        GuessPasswordGameSystem guessPasswordGameSystem = new GuessPasswordGameSystem();
        guessPasswordGameSystem.gameProcess();
    }


    @Override
    protected void start() {
        belowNumber = 0;
        topNumber = 100;
        password = new Random().nextInt(99) + 1;
        gamePlayerList = new LinkedList<>();
        System.out.println("[開始] 終極密碼 , 遊戲開始");
        setPlayerTypes();
    }

    @Override
    protected void playOneRound(int currentRound) {
        System.out.println("[回合] 第 " + currentRound + " 回合");
        for (Player gamePlayer : gamePlayerList) {
            System.out.println("[範圍] " + belowNumber + " ~ " + topNumber);
            playerGuessPassword = gamePlayer.guessPassword(belowNumber, topNumber);
            System.out.println("[解密] " + gamePlayer.getName() + " 猜了 " + playerGuessPassword);
            if (isGuessPasswordCorrect(playerGuessPassword)) {
                System.out.println("[獲勝] " + gamePlayer.getName() + " 中了");
                System.out.println("[結束] 答案 : " + password);
                break;
            }
        }
    }

    @Override
    protected boolean isGameOver() {
        return playerGuessPassword == password;
    }

    @Override
    protected void end() {
        System.out.print("[問題] 要再來一場嗎 ? <Yes> or <No> ");
        if (((scanner.nextLine()).toUpperCase()).contains("Y")) {
            gameProcess();
        }
    }

    private void setPlayerTypes() {
        String[] playerType = {"人類玩家", "奇數AI", "偶數AI", "奇偶數AI"};
        for (int setPlayerTypeTimes = 0; setPlayerTypeTimes < 4; setPlayerTypeTimes++) {
            try {
                System.out.print("[設定] " + playerType[setPlayerTypeTimes] + " 輸量 : ");
                int playerAmount = Integer.parseInt(scanner.nextLine());
                createPlayers(playerAmount, playerType[setPlayerTypeTimes]);
            } catch (NumberFormatException e) {
                System.out.println("[錯誤] 請輸入數字");
            }
        }
    }

    private void createPlayers(int playerAmount, String playerType) {
        for (int createPlayerTimes = 1; createPlayerTimes <= playerAmount; createPlayerTimes++) {
            Player player = null;
            switch (playerType) {
                case "人類玩家":
                    player = new HumanPlayer();
                    break;
                case "奇數AI":
                    player = new GuessOddNumberPasswordAI();
                    break;
                case "偶數AI":
                    player = new GuessEvenNumberPasswordAI();
                    break;
                case "奇偶數AI":
                    player = new GuessPasswordAI();
                    break;
            }
            gamePlayerList.add(player);
        }
    }

    private boolean isGuessPasswordCorrect(int playerGuessPassword) {
        if (playerGuessPassword > password) {
            topNumber = playerGuessPassword;
        } else if (playerGuessPassword < password) {
            belowNumber = playerGuessPassword;
        } else {
            return true;
        }
        return false;
    }
}
