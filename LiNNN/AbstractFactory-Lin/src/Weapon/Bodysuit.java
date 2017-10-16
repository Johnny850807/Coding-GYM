package Weapon;

import Weapon.Defense.DefenseWeapon;

public class Bodysuit implements DefenseWeapon{

	@Override
	public int getDefense() {
		return 781;
	}

	@Override
	public int getMagicDefense() {
		return 397;
	}

	@Override
	public String getName() {
		return "BodeSuit";
	}

}
