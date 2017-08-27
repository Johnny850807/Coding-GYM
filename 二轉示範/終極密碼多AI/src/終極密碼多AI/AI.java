package 終極密碼多AI;

import 撲克牌21點示範.NameGenerator;

public abstract class AI extends Player{

	@Override
	protected String nameSelf() {
		return NameGenerator.getInstance().nextName();
	}

}
