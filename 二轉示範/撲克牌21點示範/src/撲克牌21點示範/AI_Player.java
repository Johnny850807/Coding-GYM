package ���J�P21�I�ܽd;

import java.util.Random;

public class AI_Player extends Player {

	public AI_Player(ChoiceStrategy makeChoiceStrategy) {
		super(makeChoiceStrategy);
	}

	@Override
	protected void createName() {
		name = participantNames.pop();
	}

}
