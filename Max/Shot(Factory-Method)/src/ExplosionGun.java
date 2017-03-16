import Bullet.*;
public class ExplosionGun implements Gun{
	public Bullet getBullet(){
		return new ExplosionBullet();
	}
	public int getGunDamage(){
		return new ExplosionBullet().getSumDamage();
	}
	
}
