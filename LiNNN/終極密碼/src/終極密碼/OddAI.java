package ²×·¥±K½X;

public class OddAI extends Player {
	private int guessNumber = 0;
	@Override
	public int guessNumber(int small, int big) {
		
		System.out.println();
		System.out.println("Range is : " + small + " ~ " + big);

		do {
			guessNumber = (int) (Math.random() * (big - small - 2) + (small + 2));
		} while (guessNumber % 2 == 0 || guessNumber < small || guessNumber > big  );
		
		System.out.print(getPlayerType() + "-" + getPlayerName() + " ²q¤F: " + guessNumber);
		return guessNumber;
	}

	public String getPlayerType() {
		return "OddAI";
	}
}
