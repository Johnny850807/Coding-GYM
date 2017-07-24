package Strategy;

import java.util.Random;

import Player.Player;

// �H�������
public class RandomChoice implements ChoiceStrategy {

	@Override
	public boolean makeChoiceToReceiveNextCardOrNot(Player player) {
		boolean choice = new Random().nextBoolean();
		System.out.println((choice ? "y" : "n"));
		return choice ;
	}

}
