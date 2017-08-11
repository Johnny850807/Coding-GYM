package ConsoleFramework;

import TicTacToe.TicTacToe;
import TicTacToe.Item.Board;
import TicTacToe.Player.Player;
import TicTacToe.TicTacToe.CallBack;

public class ConsoleCallback implements TicTacToe.CallBack{
	private TicTacToe game;
	
	public ConsoleCallback(TicTacToe game) {
		this.game = game;
	}

	@Override
	public void onError(Throwable err) {
		System.out.println(err.getMessage());
	}

	@Override
	public void onDrawBoard(Board board) {
		board.print();
	}

	@Override
	public void onNextTurn(Player player) {
		int choice = player.makeChoice();
		delay();
		System.out.print(player + " 選擇了 ");
		delay();
		System.out.println(choice);
		delay();
		game.makeChoice(player, choice);
	}
	
	private void delay(){
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onGameResult(Player winner) {
		System.out.println(winner.getName() + " 獲得了勝利。");
	}

}
