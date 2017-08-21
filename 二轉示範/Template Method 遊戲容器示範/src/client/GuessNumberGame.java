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
		System.out.println("�w��Ө�׷��K�X�A�C���}�l�A�̥��q�쵪�ת���ӡC");
	}
	
	@Override
	protected void onStart(List<Player> players) {
		super.onStart(players);
		answer = new Random().nextInt(100);
		System.out.println("���פw�g���ͧ����C");
	}

	@Override
	protected void onPlayersCreate(List<Player> players) {
		int amount = Input.nextInt("�п�J���a�ƶq (2~5): ", 2, 5);
		for (int i = 1 ; i <= amount ; i ++  )
			players.add(createPlayerByType(Input.nextInt("��J�ϥΪ�"+i+"���� (1)�u�ꪱ�a (2)�q���G",1,2)));
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
		System.out.println(player.getName() + " �q�F�Ʀr  " + number);
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
		return Input.nextInt("�O�_�b���@��? (1) �O  (2) �_", 1, 2) == 1;
	}

	@Override
	protected void onSortingGamePlayersRank(List<Player> players) {
		players.set(0, winner);
	}

	@Override
	protected void onPrintGameResult(List<Player> ranks) {
		System.out.println("���߳ӧQ��: " + ranks.get(0).getName());
	}

	@Override
	protected void onRestartGame() {
		winner = null;
		min = 0;
		max = 100;
		System.out.println("���s�}�l�C��");
	}

	@Override
	protected void onGameOver() {
		System.out.println("�C������");
	}

	public static void main(String[] argv) {
		new GuessNumberGame().startGame();
	}
}
