package factory;

import Bullet.Bullet;
import Bullet.ExplosionBullet;
import Bullet.MachineBullet;

public class ExplosionBullrFactory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//�l�u�s�y�L�{
		return new ExplosionBullet();
	}

}
