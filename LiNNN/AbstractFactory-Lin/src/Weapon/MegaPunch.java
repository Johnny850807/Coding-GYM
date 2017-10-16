package Weapon;

import Weapon.MagicPower.MagicPower;

public class MegaPunch implements MagicPower {

	@Override
	public int getReaptedTimes() {
		return 1;
	}

	@Override
	public int getInjury() {
		return 1923;
	}

	@Override
	public int getLoseMp() {
		return 47;
	}

	@Override
	public String getName() {
		return "¦Ê¸U¾·®±À»";
	}

}
