package Weapon;

import java.util.Random;

public interface Attackable extends Weapon{
	/**this interface is to make sure the weapon can be used for injury**/
	
	int getLoseMp();
	public int getInjury() ;
	public int getReaptedTimes() ;

}
