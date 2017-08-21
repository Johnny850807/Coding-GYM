package client.Player;

import java.util.Random;
import ���J�P21�I�ܽd.NameGenerator;

public class AI extends Player {
	@Override
	protected String nameSelf() {
		return NameGenerator.getInstance().nextName();
	}

	@Override
	public int guess(int min, int max) {
		return new Random().nextInt(max-min+1)+min;
	}

	
}
