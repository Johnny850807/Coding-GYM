package Weapon;

import Weapon.Attack.AttackWeapon;

public class Punch implements AttackWeapon{

	@Override
	public int getLoseMp() {
		return 10;
	}

	@Override
	public int getInjury() {
		return 232;
	}

	@Override
	public String getName() {
		return "�n�Ȯ�";
	}

	@Override
	public int getReaptedTimes() {
		return (int)((Math.random() * 4) + 2);
	}

}
