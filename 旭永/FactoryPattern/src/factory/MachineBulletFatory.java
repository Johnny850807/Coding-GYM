package factory;

import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineBulletFatory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//子彈製造過程
		
		return new MachineBullet();
	}

}
