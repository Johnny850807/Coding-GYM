package GameContainer;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<Player, ActionResult> {
	private List<Player> players;

	public Game() {
		players = new ArrayList<>();
	}

	public void startGame() {
		onCreate();
		boolean replay;
		do {
			players.clear();
			onPlayersCreate(players);  /*遊戲實體化玩家到串列中*/
			onGameConfig(players); /*藉由玩家資訊額外設定遊戲參數*/
			onStart(players); /*啟動遊戲*/
			onPlaying(); /*遊戲邏輯遊玩過程*/
			replay = onReplayDecide(); /*決定是否重新*/
			if (replay)
				onRestartGame();  /*重啟遊戲*/
		} while (replay);
		onGameOver(); /*遊戲結束*/
	}

	protected abstract void onCreate();

	protected abstract void onPlayersCreate(List<Player> players);

	protected void onGameConfig(List<Player> players) {
		/* hook */ }

	protected void onStart(List<Player> players) {
		/* hook */ }

	protected void onPlaying() {
		do {
			onForEachPlayer();  /*走訪每個玩家回合*/
		} while (!onJudgingGameOVer());  /*判斷是否遊戲結束*/
		onSortingGamePlayersRank(players);  /*判斷玩家勝負順序*/
		onPrintGameResult(players);  /*印出遊戲結果*/
	}

	protected void onForEachPlayer() {
		for (int i = 0; i < players.size(); i++) 
		{
			Player player = players.get(i);
			try {
				ActionResult actionResult = onEachPlayerAction(player); /*玩家回合並取得玩家決策結果*/
				if (!onJudgingActionResult(player, actionResult)) /*藉由結果判斷此回合是否繼續*/
					break;
			} catch (Exception e) {
				onPlayerError(player, e); /*處理錯誤*/
				i--;
			} finally {
				onPlayerActionResume(player); /*遊戲錯誤回朔*/
			}
		}
	}

	protected abstract ActionResult onEachPlayerAction(Player player);

	protected abstract boolean onJudgingActionResult(Player player, ActionResult actionResult);

	protected void onPlayerError(Player player, Exception err) {
		/* hook */}

	protected void onPlayerActionResume(Player player) {
		/* hook */}

	protected abstract boolean onJudgingGameOVer();

	protected abstract boolean onReplayDecide();
	
	protected abstract void onSortingGamePlayersRank(List<Player> players);
	
	protected abstract void onPrintGameResult(List<Player> ranks);
	
	protected abstract void onRestartGame();
	
	protected abstract void onGameOver();

}
