package Client.Factory;

import Client.Role.Role;
import Weapon.Attackable;

public class UserPreferenceFactory {
	public static WeaponsFactory getPreferredWeapon(int num){
		switch(num)
		{
		case 1:
			return new NinjaWeaponsFactory();
		case 2:
			return new SwordHeroWeaponsFactory();
		default:
			return new FighterWeaponsFactory();
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
