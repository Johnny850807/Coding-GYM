package Game;

import Bullet.Bullet;
import Gun.ExplosionGun;
import Gun.Gun;
import Gun.MachineGun;
import Gun.SniperGun;

public class Hero {

	private Gun[] guns = {new ExplosionGun(), new MachineGun(), new SniperGun()};
	private int damage;
	private Bullet myBullet;
	
	public int attack(int num) {
		myBullet = guns[num-1].createBullet();
		damage = myBullet.getSumDamage();
		System.out.println("Damage: " + damage);
		return damage;
	}
	
}
