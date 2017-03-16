import Bullet.*;
public class MachineGun implements Gun{
	public Bullet getBullet(){
		return new MachineBullet();
	}
	public int getGunDamage(){
		return new MachineBullet().getSumDamage();
	}
}
