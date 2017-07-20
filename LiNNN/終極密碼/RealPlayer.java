package 終極密碼;

public class RealPlayer extends Player {

	private int guessNumber = 0;

	@Override
	public int guessNumber(int small, int big) {
		boolean range = false;

		while (!range) {
			System.out.println();
			System.out.println("請輸入" + small + " ~ " + big + " 數字: ");
			guessNumber = input.nextInt();

			if (guessNumber > small && guessNumber < big)
				range = true;
			else
				System.out.println("請輸入 " + small + " ~ " + big + " 範圍內的數字");
		}
		System.out.print(getPlayerType() + " " + getPlayerName() + " 猜了: " + guessNumber);
		return guessNumber;

	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		System.out.print("請輸入玩家名稱: ");
		this.playerName = input.nextLine();
	}

	public String getPlayerType() {
		return "RealPlayer";
	}

}
