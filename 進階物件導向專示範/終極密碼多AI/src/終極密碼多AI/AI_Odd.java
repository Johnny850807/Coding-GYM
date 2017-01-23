package �׷��K�X�hAI;
import java.util.Random;
public class AI_Odd extends Player {
	public AI_Odd() {
		super(PlayerType.AI, "");
	}

	@Override
	public int getGuessingNumber() {
		int max = game.getMaxBound();
		int min = game.getMinBound();
		int rand;
		if ( max == min )  //�N��q��F
			return max;
		do
		{
			//10 ~ 75 => rand()%65+10
			rand = new Random().nextInt(max-min)+min;
		}while(rand % 2 != 1 || rand < min || rand > max );  //retain odd and bounded
		return rand;
	}
}
