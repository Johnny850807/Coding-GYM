package �׷��K�X;

public class RealPlayer extends Player {

	private int guessNumber;

	@Override
	public int guessNumber(int small, int big) {
		boolean range = false;

		while (!range) {
			System.out.println("�п�J" + small + " ~ "+ big + " �Ʀr: ");
			int guessNumber = input.nextInt();
			System.out.println(guessNumber);

			if (guessNumber > small && guessNumber < big)
				range = true;
			else
				System.out.println("�п�J " + small + " ~ " + big + " �d�򤺪��Ʀr");
		}
		System.out.println(guessNumber);
		return guessNumber;

	}

	public String getPlayerType() {
		return "RealPlayer";
	}

}
