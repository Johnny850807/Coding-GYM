package Client.Factory;

import Weapon.Attack.*;
import Weapon.Defense.*;
import Weapon.MagicPower.*;

public class NinjaWeaponsFactory  implements WeaponsFactory{

	@Override
	public AttackWeapon getAttackWeapon() {
		return new Darts();
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
