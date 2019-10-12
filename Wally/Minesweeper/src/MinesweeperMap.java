import java.util.Random;
import java.util.Scanner;

public class MinesweeperMap {

    private Scanner scanner = new Scanner(System.in);
    private Grid[][] map;
    private int mapRange;
    private int mapElement = 0;
    private int openGridAmount = 0;
    private int bombAmount = 0;
    private boolean isGameOver = false;

    public MinesweeperMap setMapRange() {
        do {
            try {
                System.out.print("[輸入] 請輸入地圖範圍 : ");
                mapRange = Integer.parseInt(scanner.nextLine());
                map = new Grid[mapRange][mapRange];
            } catch (NumberFormatException e) {
                System.out.println("[錯誤] 輸入錯誤 !!!");
            }
        } while (map == null);
        return this;
    }

    public MinesweeperMap setBombAmount() {
        do {
            try {
                System.out.print("[輸入] 請輸入地雷數量 : ");
                bombAmount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[錯誤] 輸入錯誤 !!!");
            }
        } while (bombAmount == 0);
        return this;
    }

    public MinesweeperMap setBombPosition() {
        for (int thisBomb = 0; thisBomb < bombAmount; thisBomb++) {
            Grid grid;
            do {
                Random random = new Random();
                int mapRow = random.nextInt(map.length);
                int mapColumn = random.nextInt(map[0].length);
                grid = map[mapRow][mapColumn];
            } while (grid.isBomb());
            grid.setBomb();
        }
        return this;
    }

    public MinesweeperMap createGridMap() {
        for (int mapRow = 0; mapRow < mapRange; mapRow++) {
            for (int mapColumn = 0; mapColumn < mapRange; mapColumn++) {
                map[mapRow][mapColumn] = new Grid();
                mapElement++;
            }
        }
        return this;
    }

    public MinesweeperMap printMap() {
        System.out.print("0 ");
        for (int mapColumn = 1; mapColumn <= mapRange; mapColumn++) {
            System.out.print(mapColumn + " ");
        }
        System.out.println();
        for (int mapRow = 0; mapRow < mapRange; mapRow++) {
            System.out.print((mapRow + 1) + " ");
            for (int mapColumn = 0; mapColumn < mapRange; mapColumn++) {
                Grid thisGrid = map[mapRow][mapColumn];
                thisGrid.setSurroundingBombAmount(searchArroundBomb(mapRow, mapColumn));
                System.out.print(thisGrid + " ");
            }
            System.out.println();
        }
        return this;
    }

    private int searchArroundBomb(int mapRow, int mapColumn) {
        int bombAmount = 0;
        for (int borderRow = mapRow - 1; borderRow <= (mapRow + 1); borderRow++) {
            for (int borderColumn = mapColumn - 1; borderColumn <= (mapColumn + 1); borderColumn++) {
                if (borderRow >= 0 && borderRow < mapRange && borderColumn >= 0 && borderColumn < mapRange) {
                    if (map[borderRow][borderColumn].isBomb()) {
                        bombAmount++;
                    }
                }
            }
        }
        return bombAmount;
    }

    public MinesweeperMap selectGrid() {
        Grid selectGrid = null;
        do {
            try {
                System.out.print("[輸入] 請輸入想選擇格子 Y 座標 : ");
                int gridRow = (Integer.parseInt(scanner.nextLine()) - 1);
                System.out.print("[輸入] 請輸入想選擇格子 X 座標 : ");
                int gridColumn = (Integer.parseInt(scanner.nextLine()) - 1);
                selectGrid = map[gridRow][gridColumn];
                if (selectGrid.isBomb()) {
                    isGameOver = true;
                } else {
                    openGridAmount++;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("[錯誤] 輸入錯誤 !!!");
            }
        } while (selectGrid == null || selectGrid.isOpen());
        selectGrid.setOpen();
        return this;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isWin() {
        return (mapElement - bombAmount) == openGridAmount;
    }
}
