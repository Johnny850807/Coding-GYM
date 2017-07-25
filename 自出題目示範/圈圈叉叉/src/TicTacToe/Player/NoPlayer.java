package TicTacToe.Player;

public class NoPlayer extends Player{

	@Override
	protected String createName() {
		return "沒有人";
	}

	@Override
	public int makeChoice() {
		throw new RuntimeException("我不是人，沒啥選擇好做");
	}

}
