import java.util.Random;

public class MinesweeperMap {

    private Grid[][] map;
    private int mapRange;
    private int mapElement = 0;
    private int openGridAmount = 0;
    private int bombAmount = 0;
    private boolean isGameOver = false;

    public MinesweeperMap(int mapRange, int bombAmount) {
        setMapRange(mapRange);
        setBombAmount(bombAmount);
        createGridMap();
        setBombPosition();
    }

    private void setMapRange(int mapRange) {
        this.mapRange = mapRange;
        map = new Grid[mapRange][mapRange];
    }

    private void setBombAmount(int bombAmount) {
        this.bombAmount = bombAmount;
    }

    private void setBombPosition() {
        for (int thisBomb = 0; thisBomb < bombAmount; thisBomb++) {
            Grid grid;
            do {
                Random random = new Random();
                int mapRow = random.nextInt(mapRange);
                int mapColumn = random.nextInt(mapRange);
                grid = map[mapRow][mapColumn];
            } while (grid.isBomb());
            grid.setBomb(true);
        }
    }

    private void createGridMap() {
        for (int mapRow = 0; mapRow < mapRange; mapRow++) {
            for (int mapColumn = 0; mapColumn < mapRange; mapColumn++) {
                map[mapRow][mapColumn] = new Grid();
                mapElement++;
            }
        }
    }

    public int searchSurroundingBombs(int mapRow, int mapColumn) {
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

    public boolean selectGrid(int gridRow, int gridColumn) {
        Grid selectGrid = map[gridRow][gridColumn];
        if (selectGrid.isOpen()) {
            return false;
        } else {
            if (selectGrid.isBomb()) {
                isGameOver = true;
            } else {
                openGridAmount++;
            }
            selectGrid.setOpen(true);
            return true;
        }
    }

    public int getMapRange() {
        return mapRange;
    }

    public Grid[][] getMap() {
        return map;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isWin() {
        return (mapElement - bombAmount) == openGridAmount;
    }
}
