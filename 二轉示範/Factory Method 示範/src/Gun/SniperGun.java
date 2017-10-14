package Gun;

import Bullet.*;

public class SniperGun implements Gun {

	@Override
	public Bullet createBullet() {
		return new SniperBullet();
	}


}