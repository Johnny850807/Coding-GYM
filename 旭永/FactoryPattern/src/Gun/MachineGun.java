package Gun;

import Bullet.Bullet;

public class MachineGun extends Gun{

	public MachineGun(Bullet bullet) {
		super(bullet);

	}

	@Override
	public void shot() {
		System.out.println("MachineGun�ˮ` :"+bullets.getSumDamage());
		
	}

}
