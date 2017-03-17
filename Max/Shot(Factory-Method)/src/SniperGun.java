import Bullet.*;
public class SniperGun implements Gun{
	public Bullet getBullet(){
		return new SniperBullet();
	}
	public int getGunDamage(){
		return new SniperBullet().getSumDamage();
	}
}
