package �׷��K�X;

public class RealPlayer extends Player {

	private int guessNumber = 0;

	@Override
	public int guessNumber(int small, int big) {
		boolean range = false;

		while (!range) {
			System.out.println();
			System.out.println("�п�J" + small + " ~ " + big + " �Ʀr: ");
			guessNumber = input.nextInt();

			if (guessNumber > small && guessNumber < big)
				range = true;
			else
				System.out.println("�п�J " + small + " ~ " + big + " �d�򤺪��Ʀr");
		}
		System.out.print(getPlayerType() + " " + getPlayerName() + " �q�F: " + guessNumber);
		return guessNumber;

	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		System.out.print("�п�J���a�W��: ");
		this.playerName = input.nextLine();
	}

	public String getPlayerType() {
		return "RealPlayer";
	}

}
