package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public abstract class Role {

	public abstract AttackWeapon createAttackWeapon();
	public abstract DefenseWeapon createDefenseWeapon();
	public abstract MagicPower createMagicPower();
	
}
