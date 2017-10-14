package Gun;

import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineGun implements Gun{

	@Override
	public Bullet createBullet() {
		return new MachineBullet();
	}

}
