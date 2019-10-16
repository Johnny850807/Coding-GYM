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
        initialization();
        start();
        end();
        restart();
    }

    private void initialization() {
        createMap();
    }

    private void start() {
        do {
            printMap();
            selectGrid();
        } while (!minesweeperMap.isGameOver());
    }

    private void end() {
        printMap();
        printGameResult();
    }

    private void restart() {
        System.out.print("[問題] 是否要再玩一局 ? <Yes> or <No> : ");
        if ((scanner.nextLine().toUpperCase()).equals("Y")) {
            gameProcess();
        }
    }

    private void createMap() {
        int mapRange = 0, bombAmount = 0;
        do {
            try {
                System.out.print("[輸入] 請輸入地圖範圍 : ");
                mapRange = Integer.parseInt(scanner.nextLine());
                System.out.print("[輸入] 請輸入地雷數量 : ");
                bombAmount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[錯誤] 輸入錯誤 !!!");
            }
        } while (mapRange == 0 || bombAmount == 0 && bombAmount < mapRange * mapRange);
        minesweeperMap = new MinesweeperMap(mapRange, bombAmount);
    }

    private void selectGrid() {
        int gridRow = 0, gridColumn = 0, mapRange = minesweeperMap.getMapRange();
        boolean canSelect = false;
        do {
            try {
                System.out.print("[輸入] 請輸入想選擇格子 Y 座標 : ");
                gridRow = (Integer.parseInt(scanner.nextLine()) - 1);
                System.out.print("[輸入] 請輸入想選擇格子 X 座標 : ");
                gridColumn = (Integer.parseInt(scanner.nextLine()) - 1);
                canSelect = minesweeperMap.selectGrid(gridRow, gridColumn);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("[錯誤] 輸入錯誤 !!!");
            }
        } while (gridRow < 0 && gridRow >= mapRange || gridColumn < 0 && gridColumn >= mapRange || !canSelect);
    }

    private void printMap() {
        System.out.print("0 ");
        int mapRange = minesweeperMap.getMapRange();
        for (int mapColumn = 1; mapColumn <= mapRange; mapColumn++) {
            System.out.print(mapColumn + " ");
        }
        System.out.println();
        for (int mapRow = 0; mapRow < mapRange; mapRow++) {
            System.out.print((mapRow + 1) + " ");
            for (int mapColumn = 0; mapColumn < mapRange; mapColumn++) {
                Grid grid = minesweeperMap.getMap()[mapRow][mapColumn];
                grid.setSurroundingBombAmount(minesweeperMap.searchSurroundingBombs(mapRow, mapColumn));
                System.out.print(grid + " ");
            }
            System.out.println();
        }
    }

    private void printGameResult() {
        System.out.print("[結果] 玩家");
        if (minesweeperMap.isWin()) {
            System.out.println("獲勝");
        } else {
            System.out.println("落敗");
        }
    }
}
