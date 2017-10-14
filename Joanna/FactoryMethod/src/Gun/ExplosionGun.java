package Gun;

import Bullet.Bullet;
import Bullet.ExplosionBullet;

public class ExplosionGun extends Gun {

	@Override
	public Bullet createBullet() {
		return new ExplosionBullet();
	}

}
