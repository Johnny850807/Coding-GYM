package Player;

import java.util.Random;

import Strategy.ChoiceStrategy;
import ¼³§JµP21ÂI¥Ü½d.NameGenerator;

public class AI_Player extends Player {

	public AI_Player(ChoiceStrategy makeChoiceStrategy) {
		super(makeChoiceStrategy);
	}

	@Override
	protected String createName() {
		return NameGenerator.getInstance().nextName();
	}

}
