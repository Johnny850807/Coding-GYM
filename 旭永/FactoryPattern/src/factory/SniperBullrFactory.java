package factory;

import Bullet.Bullet;
import Bullet.MachineBullet;
import Bullet.SniperBullet;

public class SniperBullrFactory extends BulletFatory{

	@Override
	public Bullet createBullet() {
		//�l�u�s�y�L�{
		
		return new SniperBullet();
	}

}