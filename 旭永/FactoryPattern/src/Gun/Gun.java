package Gun;
import Bullet.*;

public abstract class Gun {
	
	public Bullet bullets;

	public Gun(Bullet bullet){
		this.bullets=bullet;
	
	}

	
	public abstract void shot();
		


	public int getSumDamage(){
		return bullets.getSumDamage();
	}
}
