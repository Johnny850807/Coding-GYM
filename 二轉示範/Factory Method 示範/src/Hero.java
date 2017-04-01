import Gun.*;

public class Hero {
	private int countRound = 0;
	private Gun[] guns = new Gun[]
			{ new MachineGun() , new SniperGun() , new ExplosionGun() };
	
	public void shootMonsterWithSpecifiedNumOfGuns(Monster monster, int numOfGun){
		printInfoOfGunChoice(numOfGun);
		monster.getInjured( guns[numOfGun].getDamage() );
		countRound ++;
	}
	
	public void printInfoOfGunChoice(int numOfGun){
		System.out.println("­^¶¯¿ï¾Ü¤F "+guns[numOfGun].getClass().getName());
	}

	public int getCountRound() {
		return countRound;
	}
	
}
