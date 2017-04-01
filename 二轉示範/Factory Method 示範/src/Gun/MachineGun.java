package Gun;

import Bullet.*;

public class MachineGun implements Gun {

	@Override
	public Bullet createBullet() {
		return new MachineBullet();
	}

	@Override
	public int getDamage() {
		return  new MachineBullet().getSumDamage();
	}

}
