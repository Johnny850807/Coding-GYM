package Gun;

import Bullet.*;


public class ExplosionGun implements Gun {

	@Override
	public Bullet createBullet() {
		return new ExplosionBullet();
	}

	@Override
	public int getDamage() {
		return  new ExplosionBullet().getSumDamage();
	}

}
