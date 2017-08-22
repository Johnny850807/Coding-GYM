package Gun;

import Bullet.Bullet;

public class ExplosionGun extends Gun{

	public ExplosionGun(Bullet bullet) {
		super(bullet);
		
	}

	@Override
	public void shot() {
		System.out.println("ExplosionGun¶Ë®` :"+bullets.getSumDamage());
		
	}

}
