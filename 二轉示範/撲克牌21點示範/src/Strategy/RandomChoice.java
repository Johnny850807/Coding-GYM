package Strategy;

import java.util.Random;

import Player.Player;

// ÀH¾÷°µ§à¾Ü
public class RandomChoice implements ChoiceStrategy {

	@Override
	public boolean makeChoiceToReceiveNextCardOrNot(Player player) {
		boolean choice = new Random().nextBoolean();
		System.out.println((choice ? "y" : "n"));
		return choice ;
	}

}
