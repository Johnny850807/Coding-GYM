package Weapon.Attack;

import java.util.Random;

public class Glove implements AttackWeapon{

	@Override
	public String getName() {
		return "®±®M";
	}

	@Override
	public int getInjury() {
		return 380+ new Random().nextInt(300);
	}

	@Override
	public int getReaptedTimes() {
		return 4;
	}
	
	@Override
	public int getLoseMp() {
		return 0;
	}

}

