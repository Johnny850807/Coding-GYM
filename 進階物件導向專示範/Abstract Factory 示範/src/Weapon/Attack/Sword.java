package Weapon.Attack;

import java.util.Random;

public class Sword implements AttackWeapon{

	@Override
	public String getName() {
		return "ªø¼C";
	}

	@Override
	public int getInjury() {
		return 720 + new Random().nextInt(250);
	}

	@Override
	public int getReaptedTimes() {
		return 2;
	}
	
	@Override
	public int getLoseMp() {
		return 0;
	}

}
