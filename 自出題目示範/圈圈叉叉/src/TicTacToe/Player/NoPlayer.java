package TicTacToe.Player;

public class NoPlayer extends Player{

	@Override
	protected String createName() {
		return "�S���H";
	}

	@Override
	public int makeChoice() {
		throw new RuntimeException("�ڤ��O�H�A�Sԣ��ܦn��");
	}

}
