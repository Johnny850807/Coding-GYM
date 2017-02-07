package Weapon.MagicPower;

import java.util.Random;

public class FireBall implements MagicPower{

	@Override
	public String getName() {
		return "¤õ²y";
	}

	@Override
	public int getInjury() {
		return 1800 + new Random().nextInt(300);
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
