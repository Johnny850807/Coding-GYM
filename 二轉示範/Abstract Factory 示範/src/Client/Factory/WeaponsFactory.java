package Client.Factory;

import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public interface WeaponsFactory {
	AttackWeapon getAttackWeapon();
	DefenseWeapon getDefenseWeapon();
	MagicPower getMagicPower();
}
