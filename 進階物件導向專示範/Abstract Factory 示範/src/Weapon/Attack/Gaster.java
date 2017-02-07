package Weapon.Attack;

import java.util.Random;

public class Gaster implements AttackWeapon{

	@Override
	public String getName() {
		return "¿E¥ú¤j¯¥";
	}

	@Override
	public int getInjury() {
		return 1200 + new Random().nextInt(300);
	}

	@Override
	public int getReaptedTimes() {
		return 1;
	}
	
	@Override
	public int getLoseMp() {
		return 0;
	}

}

