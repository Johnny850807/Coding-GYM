package factory;

import Bullet.Bullet;
import Bullet.MachineBullet;
import Bullet.SniperBullet;

public class SniperBullrFactory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//子彈製造過程
		
		return new SniperBullet();
	}

}