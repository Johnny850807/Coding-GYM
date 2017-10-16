package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Darts;
import Weapon.Defense.DefenseWeapon;
import Weapon.Defense.Shield;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;

public class Ninja extends Role {

	@Override
	public AttackWeapon createAttackWeapon() {
		return new Darts();
	}

	@Override
	public DefenseWeapon createDefenseWeapon() {
		return new Shield();
	}

	@Override
	public MagicPower createMagicPower() {
		return new ThunderBall();
	}

	
	
}
