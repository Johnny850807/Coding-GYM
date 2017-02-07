package Weapon.MagicPower;

import java.util.Random;

public class SkeletonGaster implements MagicPower{

	@Override
	public String getName() {
		return "Sans Gaster";
	}

	@Override
	public int getInjury() {
		return 2100 + new Random().nextInt(300);
	}

	@Override
	public int getLoseMp() {
		return 300;
	}
	
	@Override
	public int getReaptedTimes() {
		return 1;
	}
	
}

