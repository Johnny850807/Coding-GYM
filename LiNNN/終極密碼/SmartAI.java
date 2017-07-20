package �׷��K�X;

public class SmartAI extends Player {

	@Override
	public int guessNumber(int small, int big) {
		int guessNumber = 0;
		
		System.out.println("Range is : " + small + " ~ " + big);

		do {
			guessNumber = (int) (Math.random() * (big - small - 2) + (small + 2));
		} while (guessNumber > small && guessNumber < big);

		return guessNumber;
	}
	public String getPlayerType() {
		return "SmartAI";
	}
}
