import java.util.Scanner;

public class ChessGame {

    private Scanner input = new Scanner(System.in);
    private String[][] ChessBoard;
    private Chess blackChess;
    private Chess whiteChess;
    private int count;
    private boolean win;

    private static class ChessGameInstance {
        private static final ChessGame game = new ChessGame();
    }

    private ChessGame() {
        gamestart();
    }

    public void gamestart(){
        select();
        displayboard();
        Chessboard();
    }

    public void select() {

        int select;

        do {
            System.out.println("歡迎來到五子棋對戰");
            System.out.println("請選擇，1.玩家PK，2.人機對戰");
            select = input.nextInt();

        } while (select < 1 || select > 2);

        if (select == 1) {
            System.out.println("您選擇的是玩家PK");
            System.out.println("請輸入您的名稱");
            blackChess = new BlackChess(input.next());
            System.out.println("請輸入對方的名稱");
            whiteChess = new BlackChess(input.next());


        } else if (select == 2) {
            System.out.println("您選擇的是人機對戰");
            System.out.println("請輸入您的名稱");
            blackChess = new BlackChess(input.next());
            whiteChess = new AiChess(this);

        }
        SetUpSize();
    }

    public void SetUpSize() {

        int size;

        do {
            System.out.println("請輸入棋盤大小");
            size = input.nextInt();

        } while (size < 5);

        initialization(size);

    }

    public void initialization(int InuptSize) {

        win = false;
        ChessBoard = new String[InuptSize][InuptSize];
        for (int i = 0; i < InuptSize; i++) {
            for (int j = 0; j < InuptSize; j++) {
                ChessBoard[i][j] = "-";

            }
        }
    }

    public void Chessboard() {

        int x[], y[];
        int length = ChessBoard.length;

        while (true) {
            System.out.println(blackChess.getName() + "請選擇下的座標(x,y)");
            do {
                x = blackChess.playchess();
            } while (x[0] > length - 1 || x[0] < 0 || x[1] > length - 1 || x[1] < 0 || ChessBoard[x[0]][x[1]].equals("-") == false);
            ChessBoard[x[0]][x[1]] = "x";
            displayboard();
            CheckWin(blackChess.getName(), x[0], x[1]);
            count++;
            if (count == length * length) {
                Gameover(blackChess.getName());
            }

            System.out.println(whiteChess.getName() + "請選擇下的座標(x,y)");
            do {
                y = whiteChess.playchess();
            } while (y[0] > length - 1 || y[0] < 0 || y[1] > length - 1|| y[1] < 0 || ChessBoard[y[0]][y[1]].equals("-") == false);
            ChessBoard[y[0]][y[1]] = "o";
            displayboard();
            CheckWin(whiteChess.getName(), y[0], y[1]);
            count++;
            if (count == length * length) {
                Gameover(whiteChess.getName());
            }
        }
    }

    public static ChessGame getInstance() {
        return ChessGameInstance.game;
    }

    public void displayboard() {

        for (int i = 0; i < ChessBoard.length; i++) {
            System.out.println();

            for (int j = 0; j < ChessBoard.length; j++) {
                System.out.print(ChessBoard[i][j]);
            }
        }
        System.out.println();
    }

    public void Gameover(String name) {

        if (win == true) {
            System.out.println("遊戲結束" + name + "勝利");
        } else if (win == false) {
            System.out.println("遊戲結果:平手");
        }
        System.out.println("要重來一局嗎Y/N");
        if (input.next().equals("Y")) {
            gamestart();
        } else if (input.next().equals("N")) {
            System.exit(0);
        }
    }

    public String[][] getChessBoard(){
        return ChessBoard;
    }

    public void CheckWin(String name, int x, int y) {

        int firstpoint = 0;
        int point = 0;
        int Sidelength = ChessBoard.length - 1;

        //判斷直行
        for (int i = 1; i < 5; i++) {
            if (x - i < 0 || ChessBoard[x][y].equals(ChessBoard[x - i][y]) == false) break;
            firstpoint++;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        for (int i = 1; i <= 5 - firstpoint; i++) {
            if (x + i > Sidelength || ChessBoard[x][y].equals(ChessBoard[x + i][y]) == false) break;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        //判斷橫行
        firstpoint = 0;
        point = 0;

        for (int i = 1; i < 5; i++) {
            if (y - i < 0 || ChessBoard[x][y].equals(ChessBoard[x][y - i]) == false) break;
            firstpoint++;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        for (int i = 1; i <= 5 - firstpoint; i++) {
            if (y + i > Sidelength || ChessBoard[x][y].equals(ChessBoard[x][y + i]) == false) break;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        //判斷左斜
        firstpoint = 0;
        point = 0;

        for (int i = 1; i < 5; i++) {
            if (x - i < 0 || y - i < 0 || ChessBoard[x][y].equals(ChessBoard[x - i][y - i]) == false) break;
            firstpoint++;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        for (int i = 1; i <= 5 - firstpoint; i++) {
            if (x + i > Sidelength || y + i > Sidelength || ChessBoard[x][y].equals(ChessBoard[x + i][y + i]) == false)
                break;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        //判斷右斜
        firstpoint = 0;
        point = 0;

        for (int i = 1; i < 5; i++) {
            if (x + i > Sidelength || y - i < 0 || ChessBoard[x][y].equals(ChessBoard[x + i][y - i]) == false)
                break;
            firstpoint++;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
        for (int i = 1; i <= 5 - firstpoint; i++) {
            if (x - i < 0 || y + i > Sidelength || ChessBoard[x][y].equals(ChessBoard[x - i][y + i]) == false)
                break;
            point++;
            if (point == 4) {
                win = true;
                Gameover(name);
            }
        }
    }
}

