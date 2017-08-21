package client;

import java.util.List;
import java.util.Random;

import GameContainer.Game;
import Util.Input;
import client.Player.AI;
import client.Player.HumanPlayer;
import client.Player.Player;

public class GuessNumberGame extends Game<Player, Integer> {
	private int min = 0;
	private int max = 100;
	private int answer;
	private Player winner;
	
	@Override
	protected void onCreate() {
		System.out.println("歡迎來到終極密碼，遊戲開始，最先猜到答案的獲勝。");
	}
	
	@Override
	protected void onStart(List<Player> players) {
		super.onStart(players);
		answer = new Random().nextInt(100);
		System.out.println("答案已經產生完畢。");
	}

	@Override
	protected void onPlayersCreate(List<Player> players) {
		int amount = Input.nextInt("請輸入玩家數量 (2~5): ", 2, 5);
		for (int i = 1 ; i <= amount ; i ++  )
			players.add(createPlayerByType(Input.nextInt("輸入使用者"+i+"類型 (1)真實玩家 (2)電腦：",1,2)));
	}
	
	private Player createPlayerByType(int type) {
		if (type == 1)
			return new HumanPlayer();
		return new AI();
	}

	@Override
	protected Integer onEachPlayerAction(Player player) {
		System.out.println(min + "~" + max);
		return player.guess(min, max);
	}

	@Override
	protected boolean onJudgingActionResult(Player player, Integer number) {
		System.out.println(player.getName() + " 猜了數字  " + number);
		if (number == answer)
		{
			winner = player;
			return false;
		}
		
		if (number > answer)
			max = number - 1;
		else if (number < answer)
			min = number + 1;
		return true;
	}

	@Override
	protected boolean onJudgingGameOVer() {
		return winner != null;
	}

	@Override
	protected boolean onReplayDecide() {
		return Input.nextInt("是否在玩一場? (1) 是  (2) 否", 1, 2) == 1;
	}

	@Override
	protected void onSortingGamePlayersRank(List<Player> players) {
		players.set(0, winner);
	}

	@Override
	protected void onPrintGameResult(List<Player> ranks) {
		System.out.println("恭喜勝利者: " + ranks.get(0).getName());
	}

	@Override
	protected void onRestartGame() {
		winner = null;
		min = 0;
		max = 100;
		System.out.println("重新開始遊戲");
	}

	@Override
	protected void onGameOver() {
		System.out.println("遊戲結束");
	}

	public static void main(String[] argv) {
		new GuessNumberGame().startGame();
	}
}
