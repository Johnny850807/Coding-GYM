package Poker21PointGameSystem;

import Card.Card;
import Card.Deck;
import Player.*;

import java.util.*;

public class Poker21PointGameSystem {

    private List<Player> players;
    private Set<String> playerNames;
    private Deck deck;

    public static void main(String[] args) {
        Poker21PointGameSystem poker21PointGame = new Poker21PointGameSystem();
        poker21PointGame.gameProcess();
    }

    private void gameProcess() {
        onStart();
        onPlayOneRound();
        onEnd();
    }

    private void onStart() {
        System.out.println("[開始] 撲克牌21點，遊戲開始");
        deck = new Deck();
        players = new ArrayList<Player>();
        playerNames = new HashSet<>();
        initialization();
    }

    private void initialization() {
        for (PlayerType playerType : PlayerType.values()) {
            creatPlayer(setPlayerAmount(playerType), playerType);
        }
        setPlayerRank();
        sortPlayerRank();
        printPlayerRank();
    }

    private int setPlayerAmount(PlayerType playerType) {
        Scanner scanner = new Scanner(System.in);
        int playerAmount = -1;
        do {
            try {
                System.out.print("[設定] 請輸入" + playerType + "玩家數量 : ");
                playerAmount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[訊息] 輸入錯誤，請重新輸入 !!!");
            }
        } while (playerAmount == -1);
        return playerAmount;
    }

    private void creatPlayer(int playerAmount, PlayerType playerType) {
        for (int playerRank = 1; playerRank <= playerAmount; playerRank++) {
            Player player = checkPlayerType(playerType);
            players.add(player);
            setPlayerName(player);
        }
    }

    private Player checkPlayerType(PlayerType playerType) {
        Player player = null;
        switch (playerType) {
            case 人類:
                player = new HumanPlayer();
                break;
            case 電腦:
                player = new PokerGameAI();
                break;
        }
        return player;
    }

    private void setPlayerName(Player player) {
        String name = "";
        if (player instanceof HumanPlayer) {
            System.out.print("[設定] 請輸入玩家 " + player.getRank() + " 名字 : ");
            Scanner scanner = new Scanner(System.in);
            do {
                name = scanner.nextLine();
            } while (playerNames.contains(name));
        }
        player.setName(name);
        playerNames.add(name);
    }

    private void setPlayerRank() {
        Random random = new Random();
        int playerSize = players.size();
        for (int playerIndex = 0; playerIndex < playerSize; playerIndex++) {
            Player player1 = players.get(playerIndex);
            Player player2 = players.get(random.nextInt(playerSize));
            swapPlayer(player1, player2);
        }
    }

    private void swapPlayer(Player player1, Player player2) {
        int playerTempRank = player1.getRank();
        player1.setRank(player2.getRank());
        player2.setRank(playerTempRank);
    }

    private void sortPlayerRank() {
        players.sort(new RankComparator());
    }

    private void printPlayerRank() {
        System.out.println("[順序] :");
        for (int playerIndex = 1; playerIndex <= players.size(); playerIndex++) {
            System.out.print((players.get(playerIndex - 1)).getName());
            if (playerIndex < players.size()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    private void onPlayOneRound() {
        for (int roundtimes = 1; roundtimes <= 3; roundtimes++) {
            System.out.println("[回合] 第" + roundtimes + " 回合開始");
            onPlayerTurn();
            sortPlayerCardPoint();
            printRoundRank(roundtimes);
            printRoundResult();
        }
    }

    private void onPlayerTurn() {
        int maxCardPoint = 0;
        for (Player player : players) {
            System.out.println("[訊息] 輪到 " + player.getName() + " 了");
            onPlayerTakeCard(player);
            maxCardPoint = (getMaxCardPoint(player, maxCardPoint));
        }
    }

    private void onPlayerTakeCard(Player player) {
        player.setCardPoint(0);
        try {
            do {
                onDeckDealOneCard(player);
                checkPlayerCardPointBiggerThan21Point(player);
                System.out.println("[訊息] 玩家 " + player.getName() + " 當前牌分 : " + player.getCardPoint());
            } while (askPlayerTakeCard(player));
        } catch (CardPointOutOf21PointException ignored) {
            System.out.println("[訊息] 玩家 " + player.getName() + " 分數爆了");
        }
        System.out.println("[訊息] 玩家 " + player.getName() + " 得到了 ... " + player.getCardPoint() + " 分");
    }

    private void onDeckDealOneCard(Player player) {
        Card card = null;
        do {
            try {
                card = deck.dealCard();
                System.out.println("[訊息] 翻開了 .... " + card);
                int cardPoint = (player.getCardPoint() + card.getRank());
                player.setCardPoint(cardPoint);
            } catch (IndexOutOfBoundsException e) {
                deck.suffle();
            }
        } while (card == null);
    }

    private void checkPlayerCardPointBiggerThan21Point(Player player) {
        if (player.getCardPoint() > 21) {
            player.setCardPoint(0);
            throw new CardPointOutOf21PointException();
        }
    }

    private boolean askPlayerTakeCard(Player player) {
        boolean isTakeNextCard = false;
        if (player.getCardPoint() != 21) {
            System.out.print("[訊息] 玩家 " + player.getName() + " 要翻開下一張牌嗎 ? <Yes> or <No> : ");
            if (player instanceof HumanPlayer) {
                isTakeNextCard = (new Scanner(System.in).nextLine().toUpperCase()).contains("Y");
            } else {
                if (player.getCardPoint() + 5 >= 21) {
                    isTakeNextCard = new Random().nextBoolean();
                } else {
                    isTakeNextCard = true;
                }
                System.out.print((isTakeNextCard) ? "Y" : "N");
                System.out.println();
            }
        }
        return isTakeNextCard;
    }

    private int getMaxCardPoint(Player player, int maxScore) {
        int playerCardPoint = player.getCardPoint();
        return (playerCardPoint > maxScore) ? playerCardPoint : maxScore;
    }

    private void sortPlayerCardPoint() {
        players.sort(new CardPointComparator());
    }

    private void printRoundResult() {
        Player maxCardPointPlayer = players.get(0);
        maxCardPointPlayer.setScore((maxCardPointPlayer.getScore() + 1));
        System.out.println("[訊息] 此回合由玩家 " + maxCardPointPlayer.getName() + " 得到一分\n");
    }

    private void printRoundRank(int round) {
        System.out.println("\n[排行] 第 " + round + " 回合牌分榜 : ");
        for (int playerScoreRank = 1; playerScoreRank <= players.size(); playerScoreRank++) {
            Player player = players.get(playerScoreRank - 1);
            System.out.println(player.getRank() + " 號玩家 -- " + player.getName() + " 牌分 : " + player.getCardPoint());
        }
        System.out.println();
    }

    private void onEnd() {
        System.out.println("[訊息] 撲克牌21點，遊戲結束\n");
        sortPlayerScore();
        printGameResult();
        if (askPlayOneGame()) {
            System.out.println();
            gameProcess();
        }
    }

    private void sortPlayerScore() {
        players.sort(new ScoreComparator());
    }

    private void printGameResult() {
        System.out.println("[排行] 總分榜 : ");
        for (int playerScoreRank = 1; playerScoreRank <= players.size(); playerScoreRank++) {
            Player player = players.get(playerScoreRank - 1);
            System.out.println("第 " + playerScoreRank + " 名 -- " + player.getRank() + " 號玩家 -- " + player.getName() + " 總分 : " + player.getScore());
        }
        System.out.println();
    }

    private boolean askPlayOneGame() {
        System.out.print("[訊息] 要重玩撲克牌21嗎 ? <Yes> or <No> : ");
        return (new Scanner(System.in).nextLine().toUpperCase()).contains("Y");
    }

}
