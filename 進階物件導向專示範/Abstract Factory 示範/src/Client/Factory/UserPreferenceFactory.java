package Client.Factory;

import Client.Role.Role;
import Weapon.Attackable;

public class UserPreferenceFactory {
	public static WeaponsFactory getPreferredWeapon(int num){
		switch(num)
		{
		case 1:
			return new NinjaWeaponsFactory();
		default:
			return new SwordHeroWeaponsFactory();
		}
	}
	
	public static Attackable getPreferredAttackFromRole(int num , Role user){
		switch(num)
		{
		case 1:
			return user.getAttackWeapon();
		default:
			return user.getMagicPower();
		}
	}
}
