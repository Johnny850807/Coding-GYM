package Gun;

import Bullet.Bullet;

public abstract class Gun {
	
	private Bullet bullet;
	private int damage;
	
	public Gun() {
		bullet = createBullet();
		damage = bullet.getSumDamage();
	}
	
	public abstract Bullet createBullet();
	
	public int getDamage() {
		return damage;
	}
}
