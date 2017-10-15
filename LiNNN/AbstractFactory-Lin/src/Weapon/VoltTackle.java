package Weapon;

import Weapon.MagicPower.MagicPower;

public class VoltTackle implements MagicPower{

	@Override
	public int getReaptedTimes() {
		return 1;
	}

	@Override
	public int getInjury() {
		return 2391;
	}

	@Override
	public int getLoseMp() {
		return 300;
	}

	@Override
	public String getName() {
		return "¥ñ¯S§ðÀ»";
	}

}
