package Weapon.Attack;

import java.util.Random;

public class Gun implements AttackWeapon{

	@Override
	public String getName() {
		return "¤âºj";
	}

	@Override
	public int getInjury() {
		return 550+ new Random().nextInt(250);
	}

	@Override
	public int getReaptedTimes() {
		return 3;
	}
	
	@Override
	public int getLoseMp() {
		return 0;
	}

}

