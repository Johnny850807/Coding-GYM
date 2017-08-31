package �׷��K�X�hAI;

import java.util.Random;

public class EvenAI extends AI{

	@Override
	protected String getPlayerType() {
		return "����AI";
	}

	@Override
	protected int guess(int min, int max) {
		if ( max == min ) 
			return max;
		int rand;
		do
		{
			rand = new Random().nextInt(max-min)+min;
		}while(rand % 2 != 0 || rand < min || rand > max );  
		return rand;
	}

}
