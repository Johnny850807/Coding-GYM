import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static BlackJack game = new BlackJack();
    private static List<Player> playersList = game.getPlayers();

    public static void main(String[] args) {
        setPlayers();
        gameStart();

    }

    public static void setPlayers() {

        System.out.println("設置玩家數量");
        int playersAmount = input.nextInt();
        System.out.println("設置電腦數量");
        int aiAmount = input.nextInt();

        for (int i = 1; i <= playersAmount; i++) {
            System.out.println("請輸入玩家" + i + "姓名:");
            playersList.add(new HumanPlayer(input.next(), game));
        }

        for (int i = 1; i <= aiAmount; i++) {
            playersList.add(new AiPlayer(i, game));
        }

        System.out.println("順序 :");
        for (Player player : playersList) {
            System.out.print(player.getName() + "->");
        }
    }

    public static void gameStart() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("第 " + i + " 回合開始!!");
            boolean exceedScore;
            for (Player player : playersList) {
                System.out.println("輪到 " + player.getName() + " 了 !!");
                boolean takeNextCard = false;
                do {
                    System.out.println(player.play());
                    exceedScore = game.checkExceed(player.getScore());
                    if (!exceedScore) {
                        System.out.println("請問" + player.getName() + "要翻開下一張牌嗎(y/n)?");
                        takeNextCard = player.select().equals("y");
                    }
                } while (!exceedScore && takeNextCard);

                if (player.getScore() > 21) {
                    player.setScore(0);
                }

                System.out.println(player.getName() + "得到了 .. " + player.getScore() + "分");

            }
            List<Player> rank = new ArrayList<>(game.roundWinner());

            System.out.println("此回合由 " + rank.get(0).getName()+ " 得到一分 !!");
        }
        playersList = game.finalWinner();
        System.out.println("遊戲結束!!!!!!");
        for (int i = 0, j = 1; i < playersList.size(); i++, j++) {
            System.out.println("第" + j + "名" + "--" + playersList.get(i).getName());
        }

    }
}
