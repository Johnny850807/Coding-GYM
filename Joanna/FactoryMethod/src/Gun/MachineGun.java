package Gun;

import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineGun extends Gun{

	@Override
	public Bullet createBullet() {
		return new MachineBullet();
	}

}
