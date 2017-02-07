package Weapon.MagicPower;

import java.util.Random;

public class ThunderBall implements MagicPower{

	@Override
	public String getName() {
		return "¹p¹q²y";
	}

	@Override
	public int getInjury() {
		return 1700 + new Random().nextInt(800);
	}
	
	@Override
	public int getLoseMp() {
		return 100;
	}
	
	@Override
	public int getReaptedTimes() {
		return 1;
	}

}

