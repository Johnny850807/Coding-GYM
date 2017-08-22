package Gun;

import Bullet.Bullet;

public class SniperGun extends Gun{

	public SniperGun(Bullet bullet) {
		super(bullet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shot() {
		System.out.println("SniperGun¶Ë®` :"+bullets.getSumDamage());
		
		
	}

}
