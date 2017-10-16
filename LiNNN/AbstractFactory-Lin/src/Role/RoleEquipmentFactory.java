package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public interface RoleEquipmentFactory {
	AttackWeapon setUpAttackWeapon();

	DefenseWeapon setUpDefenseWeapon();

	MagicPower setUpMagicPower();
}
