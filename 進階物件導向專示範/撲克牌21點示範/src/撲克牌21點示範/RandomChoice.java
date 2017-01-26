package ¼³§JµP21ÂI¥Ü½d;

import java.util.Random;

public class RandomChoice implements ChoiceStrategy {

	@Override
	public boolean makeChoiceToReceiveNextCardOrNot(Player player) {
		boolean choice = new Random().nextBoolean();
		System.out.println((choice ? "y" : "n"));
		return choice ;
	}

}
