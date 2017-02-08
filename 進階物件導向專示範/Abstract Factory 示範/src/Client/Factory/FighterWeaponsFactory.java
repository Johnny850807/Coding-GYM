package Client.Factory;

import Weapon.Attack.*;
import Weapon.Defense.DefenseWeapon;
import Weapon.Defense.Shield;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;

public class FighterWeaponsFactory implements WeaponsFactory{

	@Override
	public AttackWeapon getAttackWeapon() {
		return new Glove();
	}

	@Override
	public DefenseWeapon getDefenseWeapon() {
		return new Shield();
	}

	@Override
	public MagicPower getMagicPower() {
		return new ThunderBall();
	}

}

