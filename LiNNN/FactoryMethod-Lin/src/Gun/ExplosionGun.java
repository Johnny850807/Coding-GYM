package Gun;

import Bullet.Bullet;
import Bullet.ExplosionBullet;

public class ExplosionGun implements Gun {
	
	@Override
	public Bullet createBullet() {
		return new ExplosionBullet();
	}

}
