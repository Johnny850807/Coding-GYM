package factory;

import Bullet.Bullet;
import Bullet.ExplosionBullet;
import Bullet.MachineBullet;

public class ExplosionBullrFactory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//子彈製造過程
		return new ExplosionBullet();
	}

}
