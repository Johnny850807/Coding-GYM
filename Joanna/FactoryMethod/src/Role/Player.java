package Role;

import Gun.ExplosionGun;
import Gun.Gun;
import Gun.MachineGun;
import Gun.SniperGun;

public class Player {
	
	private Gun[] guns = {null, new MachineGun(), new ExplosionGun(), new SniperGun()};
	
	public int getSumDamage(int selection) {
		return guns[selection].createBullet().getSumDamage();
	}
	
}
