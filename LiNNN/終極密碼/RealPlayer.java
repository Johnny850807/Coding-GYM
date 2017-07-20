package 終極密碼;

public class RealPlayer extends Player {

	private int guessNumber;

	@Override
	public int guessNumber(int small, int big) {
		boolean range = false;

		while (!range) {
			System.out.println("請輸入" + small + " ~ "+ big + " 數字: ");
			int guessNumber = input.nextInt();
			System.out.println(guessNumber);

			if (guessNumber > small && guessNumber < big)
				range = true;
			else
				System.out.println("請輸入 " + small + " ~ " + big + " 範圍內的數字");
		}
		System.out.println(guessNumber);
		return guessNumber;

	}

	public String getPlayerType() {
		return "RealPlayer";
	}

}
