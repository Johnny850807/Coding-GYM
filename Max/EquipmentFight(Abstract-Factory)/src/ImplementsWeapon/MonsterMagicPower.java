package ImplementsWeapon;
import Weapon.MagicPower.MagicPower;

public class MonsterMagicPower implements MagicPower{

	@Override
	public int getReaptedTimes() {
		return 1;
	}
	@Override
	public int getInjury() {
		return 1234;
	}
	@Override
	public int getLoseMp() {
		return 100;
	}

	@Override
	public String getName() {
		return "«lÃz¤ô²y";
	}

}
