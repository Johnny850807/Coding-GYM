import java.util.Scanner;

public class MinesweeperGameSystem {

    private MinesweeperMap minesweeperMap;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MinesweeperGameSystem minesweeperGame = new MinesweeperGameSystem();
        minesweeperGame.gameProcess();
    }

    private void gameProcess() {
        System.out.println("[開始] 踩地雷,遊戲開始");
        onStart().onOneGameRound().onGameEnd().onRestart();
    }

    private MinesweeperGameSystem onStart() {
        createMap();
        return this;
    }

    private MinesweeperGameSystem onOneGameRound() {
        do {
            minesweeperMap.printMap().selectGrid();
        } while (!minesweeperMap.isGameOver());
        return this;
    }

    private MinesweeperGameSystem onGameEnd() {
        System.out.print("[結果] 玩家");
        if (minesweeperMap.isWin()) {
            System.out.println("獲勝");
        } else {
            System.out.println("落敗");
        }
        return this;
    }

    private void onRestart() {
        System.out.print("[問題] 是否要再玩一局 ? <Yes> or <No> : ");
        if ((scanner.nextLine().toUpperCase()).equals("Y")) {
            gameProcess();
        }
    }

    protected void createMap() {
        minesweeperMap = new MinesweeperMap()
                .setMapRange()
                .createGridMap()
                .setBombAmount()
                .setBombPosition();
    }
}
