import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static CardFightSystem cardFightSystem = new CardFightSystem();

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        System.out.println("========歡迎來到卡片對戰遊戲========");
        System.out.println("請輸入玩家名稱");

        String playerName = input.next();
        cardFightSystem.addPlayer(new HumanPlayer(playerName));
        cardFightSystem.addPlayer(new AiPlayer("電腦"));

        for (int i = 1; i <= 3; i++) {
            System.out.println("===========回合" + i + "開始了===========");
            cardFightSystem.gameStart();
        }
        Player winner = cardFightSystem.getWinner();

        System.out.println(winner.getName() + " 贏了本場遊戲");
        System.out.println("========遊戲結束========");
    }
}
