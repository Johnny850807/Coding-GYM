package �׷��K�X�hAI;

import ���J�P21�I�ܽd.NameGenerator;

public abstract class AI extends Player{

	@Override
	protected String nameSelf() {
		return NameGenerator.getInstance().nextName();
	}

}
