package Player;

import java.util.Random;

public class AIPlayer extends Player {
	
	@Override
	protected String nameSelf() {
		name = "¹q¸£";
		return name;
	}

	@Override
	public int selectCard() {
		Random ran = new Random();
		int selection = (int) ran.nextInt(3);
		System.out.println(selection);
		return selection;
	}
	
}
