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
			onPlayersCreate(players);  /*�C������ƪ��a���C��*/
			onGameConfig(players); /*�ǥѪ��a��T�B�~�]�w�C���Ѽ�*/
			onStart(players); /*�ҰʹC��*/
			onPlaying(); /*�C���޿�C���L�{*/
			replay = onReplayDecide(); /*�M�w�O�_���s*/
			if (replay)
				onRestartGame();  /*���ҹC��*/
		} while (replay);
		onGameOver(); /*�C������*/
	}

	protected abstract void onCreate();

	protected abstract void onPlayersCreate(List<Player> players);

	protected void onGameConfig(List<Player> players) {
		/* hook */ }

	protected void onStart(List<Player> players) {
		/* hook */ }

	protected void onPlaying() {
		do {
			onForEachPlayer();  /*���X�C�Ӫ��a�^�X*/
		} while (!onJudgingGameOVer());  /*�P�_�O�_�C������*/
		onSortingGamePlayersRank(players);  /*�P�_���a�ӭt����*/
		onPrintGameResult(players);  /*�L�X�C�����G*/
	}

	protected void onForEachPlayer() {
		for (int i = 0; i < players.size(); i++) 
		{
			Player player = players.get(i);
			try {
				ActionResult actionResult = onEachPlayerAction(player); /*���a�^�X�è��o���a�M�����G*/
				if (!onJudgingActionResult(player, actionResult)) /*�ǥѵ��G�P�_���^�X�O�_�~��*/
					break;
			} catch (Exception e) {
				onPlayerError(player, e); /*�B�z���~*/
				i--;
			} finally {
				onPlayerActionResume(player); /*�C�����~�^��*/
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
