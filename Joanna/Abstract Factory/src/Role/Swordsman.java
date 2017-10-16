package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Sword;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.FireBall;
import Weapon.MagicPower.MagicPower;

public class Swordsman extends Role {

	@Override
	public AttackWeapon createAttackWeapon() {
		return new Sword();
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
