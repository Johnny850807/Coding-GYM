package Role;

import Gun.ExplosionGun;
import Gun.Gun;
import Gun.MachineGun;
import Gun.SniperGun;

public class Player {
	
	private Gun gun;
	
	public void chooseGun(int selection) {
		switch (selection) {
		case 1:
			gun = new MachineGun();
			break;
		case 2:
			gun = new ExplosionGun();
			break;
		case 3:
			gun = new SniperGun();
			break;

		default:
			break;
		}
	}
	
	public int getSumDamage() {
		return gun.getDamage();
	}
	
}
