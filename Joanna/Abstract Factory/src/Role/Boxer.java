package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Glove;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.FireBall;
import Weapon.MagicPower.MagicPower;

public class Boxer extends Role {

	@Override
	public AttackWeapon createAttackWeapon() {
		return new Glove();
	}

	@Override
	public DefenseWeapon createDefenseWeapon() {
		return new Armor();
	}

	@Override
	public MagicPower createMagicPower() {
		return new FireBall();
	}

}
