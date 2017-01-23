package �׷��K�X�hAI;

import java.util.Random;

public class AI_Even extends Player {
	public AI_Even() {
		super(PlayerType.AI, "" );
	}

	@Override
	public int getGuessingNumber() {
		int max = game.getMaxBound();
		int min = game.getMinBound();
		if ( max == min )  //�N��q��F
			return max;
		int rand;
		do
		{
			//10 ~ 75 => rand()%65+10
			rand = new Random().nextInt(max-min)+min;
		}while(rand % 2 != 0 || rand < min || rand > max );  //retain odd and bounded
		return rand;
	}
}
