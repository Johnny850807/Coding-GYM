package Player;

import java.util.Random;

import Weapon.Attackable;
import Weapon.Weapon;

public class Monster extends Player {

	@Override
	protected String nameSelf() {
		return "й╟кл";
	}

	@Override
	protected int initHealthPoint() {
		return 10000;
	}

	@Override
	protected int initMagicPoint() {
		return 3000;
	}

	@Override
	public int selectRole() {
		Random random = new Random();
		return random.nextInt(3) + 1;
	}

	@Override
	public Attackable selectAction() {
		Random random = new Random();
		return weapons[random.nextInt(2) + 1];
	}

}
