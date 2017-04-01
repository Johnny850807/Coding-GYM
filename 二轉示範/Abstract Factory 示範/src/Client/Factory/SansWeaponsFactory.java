package Client.Factory;

import Weapon.Attack.*;
import Weapon.Defense.*;
import Weapon.MagicPower.*;

public class SansWeaponsFactory  implements WeaponsFactory {

	@Override
	public AttackWeapon getAttackWeapon() {
		return new Gaster();
	}

	@Override
	public DefenseWeapon getDefenseWeapon() {
		return new Skeleton();
	}

	@Override
	public MagicPower getMagicPower() {
		return new SkeletonGaster();
	}

}
