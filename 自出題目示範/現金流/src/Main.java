import controllers.CashflowGameController;
import controllers.GameRecorder;
import game.CashFlowGame;
import game.CashFlowGameImpl;
import utils.Input;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Main {
    private final static String GAME_SAVE_PATH = "gameSave.obj";

    public static void main(String[] args) {
        int choice = Input.nextInt("請選擇 (1) 開始新遊戲 (2) 載入上次存擋: ");
        CashFlowGameImpl game;
        GameRecorder gameRecorder;
        CashflowGameController controller;
        if (choice == 1) {
            game = new CashFlowGameImpl();
        } else {
            game = GameRecorder.loadGame(GAME_SAVE_PATH);
        }

        gameRecorder = new GameRecorder(GAME_SAVE_PATH, game);
        controller = new CashflowGameController(game);
        controller.addListener(gameRecorder);
    }

    private void
}
