import Bullet.Bullet;
import Gun.*;

public class Hero {
	private Gun[] guns = new Gun[]
			{ new MachineGun() , new SniperGun() , new ExplosionGun() };
	
	public void shootMonsterWithSpecifiedNumOfGuns(Monster monster, int numOfGun){
		System.out.println("­^¶¯¿ï¾Ü¤F "+guns[numOfGun].getClass().getName());
		Bullet bullet = guns[numOfGun].createBullet();
		monster.getInjured( bullet.getSumDamage() );
	}

}
