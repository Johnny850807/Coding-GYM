package factory;

import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineBulletFatory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//�l�u�s�y�L�{
		
		return new MachineBullet();
	}

}
