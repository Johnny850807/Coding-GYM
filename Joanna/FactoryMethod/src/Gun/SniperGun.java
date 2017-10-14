package Gun;

import Bullet.Bullet;
import Bullet.SniperBullet;

public class SniperGun implements Gun {

	@Override
	public Bullet createBullet() {
		return new SniperBullet();
	}

}
