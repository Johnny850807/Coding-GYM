package Client.Factory;

import Weapon.Attack.*;
import Weapon.Defense.*;
import Weapon.MagicPower.*;


public class SwordHeroWeaponsFactory implements WeaponsFactory{

	@Override
	public AttackWeapon getAttackWeapon() {
		return new Sword();
	}

	@Override
	public DefenseWeapon getDefenseWeapon() {
		return new Armor();
	}

	@Override
	public MagicPower getMagicPower() {
		return new FireBall();
	}

}
