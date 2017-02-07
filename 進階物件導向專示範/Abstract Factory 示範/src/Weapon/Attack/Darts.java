package Weapon.Attack;

import java.util.Random;

public class Darts implements AttackWeapon{

	@Override
	public String getName() {
		return "­¸Ãð";
	}

	@Override
	public int getInjury() {
		return 250 + new Random().nextInt(100);
	}

	@Override
	public int getReaptedTimes() {
		return 9;
	}

	@Override
	public int getLoseMp() {
		return 0;
	}

}
