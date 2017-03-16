
public class Hero {
	private Gun[] myGun = { new MachineGun() , new ExplosionGun(),new SniperGun()};
	private int whichGun;
	public Hero(){
	}
	public void setHeroGun(int which){
		this.whichGun = which;
	}
	public int getGunDamage(){
		return myGun[whichGun-1].getGunDamage();
	}
	
}
